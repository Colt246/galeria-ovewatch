const API = "http://localhost:8080/heroes";
let heroes = [];

// Cargar héroes desde la API de Spring Boot
fetch(API)
    .then(res => res.json())
    .then(data => {
        heroes = data;
        renderizar();
    })
    .catch(() => alert("No se puede conectar con la API. ¿Está Spring Boot arrancado?"));

function renderizar() {
    const texto = document.getElementById("buscar").value.toLowerCase();
    const rol   = document.getElementById("filtroRol").value;
    const orden = document.getElementById("orden").value;

    const subRol = document.getElementById("filtroSubRol").value;
    let lista = heroes.filter(h =>
        h.nombre.toLowerCase().includes(texto) &&
        (rol === "todos" || h.rol === rol) &&
        (subRol === "todos" || h.subRol === subRol)
    );

    lista.sort((a, b) => orden === "az"
        ? a.nombre.localeCompare(b.nombre)
        : b.nombre.localeCompare(a.nombre));

    const galeria = document.getElementById("galeria");
    galeria.innerHTML = "";

    lista.forEach(h => {
        const badgeClass = h.rol === "tanque" ? "badge-tanque"
                         : h.rol === "dps"    ? "badge-dps"
                         : "badge-apoyo";

        const iconoSubRol = h.subRol ? "Imagenes/habilidades_comunes/Sub-Rol_" +
            (h.rol === "tanque" ? "Tank" : h.rol === "dps" ? "Damage" : "Support") +
            "_" +
            (h.subRol === "fuerte" ? "Bruiser" :
             h.subRol === "iniciador" ? "Initiator" :
             h.subRol === "valeroso" ? "Stalwart" :
             h.subRol === "especialista" ? "Specialist" :
             h.subRol === "flanqueador" ? "Flanker" :
             h.subRol === "reconocimiento" ? "Recon" :
             h.subRol === "tirador" ? "Sharpshooter" :
             h.subRol === "estratega" ? "Tactician" :
             h.subRol === "medico" ? "Medic" :
             h.subRol === "superviviente" ? "Survivor" : "") +
            ".svg" : "";

        const col = document.createElement("div");
        col.className = "col";
        col.innerHTML = `
            <div class="tarjeta h-100" data-id="${h.id}">
                <img src="${h.portada}" alt="${h.nombre}"
                     onerror="this.src='https://placehold.co/300x200?text=${encodeURIComponent(h.nombre)}'">
                <div class="tarjeta-body">
                    <h6 class="mb-1">${h.nombre}</h6>
                    <div class="d-flex justify-content-between align-items-center w-100">
                        <span class="badge ${badgeClass}">${h.rol}</span>
                        ${iconoSubRol ? `<img src="${iconoSubRol}" alt="${h.subRol}" title="${h.subRol}" style="width:20px;height:20px;object-fit:contain;" onerror="this.style.display='none'">` : ""}
                    </div>
                    <p class="small mt-2 mb-2">${h.descripcion}</p>
                    <div class="d-flex gap-2">
                        <button class="btn btn-sm btn-editar btnEditar">✏️<br>Editar</button>
                        <button class="btn btn-sm btn-eliminar btnEliminar">🗑️<br>Eliminar</button>
                    </div>
                </div>
            </div>`;
        col.querySelector(".tarjeta").addEventListener("click", () => abrirDetalle(h));
        col.querySelector(".btnEliminar").addEventListener("click", (e) => {
            e.stopPropagation();
            if (confirm("¿Seguro que quieres eliminar a " + h.nombre + "?")) {
                fetch(API + "/" + h.id, { method: "DELETE" })
                    .then(() => {
                        heroes = heroes.filter(x => x.id !== h.id);
                        renderizar();
                    });
            }
        });

        col.querySelector(".btnEditar").addEventListener("click", (e) => {
            e.stopPropagation();
            abrirEditar(h);
        });
        galeria.appendChild(col);
    });
}

function abrirDetalle(h) {
    document.getElementById("modalNombre").textContent = h.nombre;
    document.getElementById("modalImg").src = h.portada;
    document.getElementById("modalDesc").textContent = h.descripcion;
    document.getElementById("modalVida").textContent = h.vida;

    const iconoRol = h.rol === "tanque"
        ? "Imagenes/habilidades_comunes/rol_tank.svg"
        : h.rol === "dps"
        ? "Imagenes/habilidades_comunes/rol_dps.svg"
        : "Imagenes/habilidades_comunes/rol_supp.svg";
    document.getElementById("modalIconoRol").src = iconoRol;

    document.getElementById("modalPasivaRol").innerHTML = "";
    document.getElementById("modalPasivaRol").className = "w-100 rounded";
    document.getElementById("modalPasivaRol").style.display = "none";
    document.getElementById("modalFilaSuperior").innerHTML = "";
    document.getElementById("modalHabilidades").innerHTML = "";
    document.getElementById("modalDefinitiva").innerHTML = "";

    const subRolAnterior = document.getElementById("modalSubRol");
    if (subRolAnterior) subRolAnterior.remove();

    if (!h.habilidades) {
        new bootstrap.Modal(document.getElementById("modalDetalle")).show();
        return;
    }

    const armas         = h.habilidades.filter(hb => hb.tipo === "arma");
    const pasivaRol     = h.habilidades.find(hb => hb.tipo === "pasivaRol");
    const pasivaSubRol  = h.habilidades.find(hb => hb.tipo === "pasivaSubRol");
    const pasivaPropias = h.habilidades.filter(hb => hb.tipo === "pasivaPropia");
    const habilidades   = h.habilidades.filter(hb => hb.tipo === "habilidad");
    const definitivas   = h.habilidades.filter(hb => hb.tipo === "definitiva");


    document.getElementById("modalPasivaRol").style.display = "none";


    // Pasiva de rol
    if (pasivaRol) {
        document.getElementById("modalPasivaRol").className = "w-100 rounded p-2 bloque-pasiva-rol";
        document.getElementById("modalPasivaRol").style.display = "block";
        document.getElementById("modalPasivaRol").innerHTML = `
            <div class="d-flex align-items-center gap-2">
                <img src="${pasivaRol.icono}" style="width:28px;height:28px;object-fit:contain;"
                     onerror="this.style.display='none'">
                <div class="text-start">
                    <strong class="small">${pasivaRol.titulo}</strong>
                    <p class="small mb-0 texto-secundario">${pasivaRol.descripcion}</p>
                </div>
            </div>`;
    }

    // Pasiva de sub-rol
    if (pasivaSubRol) {
        const divSubRol = document.createElement("div");
        divSubRol.id = "modalSubRol";
        divSubRol.className = "w-100 rounded p-2 text-center bloque-pasiva-rol mt-2";
        divSubRol.innerHTML = `
            <div class="d-flex align-items-center gap-2">
                <img src="${pasivaSubRol.icono}" style="width:28px;height:28px;object-fit:contain;"
                     onerror="this.style.display='none'">
                <div class="text-start">
                    <strong class="small">${pasivaSubRol.titulo}</strong>
                    <p class="small mb-0 texto-secundario">${pasivaSubRol.descripcion}</p>
                </div>
            </div>`;
        document.getElementById("modalPasivaRol").after(divSubRol);
        document.getElementById("modalPasivaRol").style.display = "block";
    }

    // Fila superior: armas + pasiva propia
    const filaSuperior = document.getElementById("modalFilaSuperior");
    const itemsSuperior = [...armas];
    for (let i = 0; i < pasivaPropias.length; i++) {
        const item = pasivaPropias[i];
        item.esPropia = true;
        itemsSuperior.push(item);
    }

    itemsSuperior.forEach(item => {
        const col = document.createElement("div");
        col.className = "col-6";
        const claseBloque = item.esPropia ? "bloque-pasiva-propia" : "bloque-arma";
        const etiqueta    = item.esPropia ? "Pasiva del personaje" : "Arma";
        col.innerHTML = `
            <div class="p-2 rounded h-100 d-flex flex-column align-items-center text-center gap-1 ${claseBloque}">
                <img src="${item.icono}" style="width:32px;height:32px;object-fit:contain;"
                     onerror="this.style.display='none'">
                <strong class="small">${item.titulo}</strong>
                <p class="small mb-0 texto-secundario" style="font-size:0.75rem;">${item.descripcion}</p>
                <span class="badge mt-auto" style="background-color:#333;font-size:0.6rem;">${etiqueta}</span>
            </div>`;
        filaSuperior.appendChild(col);
    });

    // Habilidades normales
    const contenedorHab = document.getElementById("modalHabilidades");
    habilidades.forEach(hab => {
        const div = document.createElement("div");
        div.className = "d-flex align-items-start gap-2 mb-2";
        div.innerHTML = `
            <img src="${hab.icono}" style="width:28px;height:28px;object-fit:contain;flex-shrink:0;"
                 onerror="this.style.display='none'">
            <div>
                <strong class="small">${hab.titulo}</strong>
                <p class="small mb-0 texto-secundario">${hab.descripcion}</p>
            </div>`;
        contenedorHab.appendChild(div);
    });

    // Definitiva(s)
    const contenedorDef = document.getElementById("modalDefinitiva");
    if (definitivas.length > 0) {
        contenedorDef.innerHTML = `<p class="mb-1 fw-bold small" style="color:#e94560;">Habilidad Definitiva</p>`;
        definitivas.forEach(def => {
            const div = document.createElement("div");
            div.className = "d-flex align-items-start gap-2 mb-1";
            div.innerHTML = `
                <img src="${def.icono}" style="width:28px;height:28px;object-fit:contain;flex-shrink:0;"
                     onerror="this.style.display='none'">
                <div>
                    <strong class="small">${def.titulo}</strong>
                    <p class="small mb-0 texto-secundario">${def.descripcion}</p>
                </div>`;
            contenedorDef.appendChild(div);
        });
    }

    new bootstrap.Modal(document.getElementById("modalDetalle")).show();
}

// Filtros
document.getElementById("buscar").addEventListener("input", renderizar);
document.getElementById("filtroRol").addEventListener("change", renderizar);
document.getElementById("orden").addEventListener("change", renderizar);
document.getElementById("filtroSubRol").addEventListener("change", renderizar);

// Modo oscuro / claro
document.getElementById("btnModo").addEventListener("click", () => {
    document.body.classList.toggle("modo-claro");
    const esModoClaro = document.body.classList.contains("modo-claro");
    document.getElementById("btnModo").textContent = esModoClaro ? "🌙 Modo Oscuro" : "☀️ Modo Claro";
});

// Añadir héroe
document.getElementById("btnAnadir").addEventListener("click", () => {
    // Limpiar formulario
    document.getElementById("nuevoNombre").value = "";
    document.getElementById("nuevoRol").value = "tanque";
    document.getElementById("nuevoVida").value = "";
    document.getElementById("nuevoDesc").value = "";
    document.getElementById("nuevoPortada").value = "";
    document.getElementById("pasivaNombre").value = "";
    document.getElementById("pasivaIcono").value = "";
    document.getElementById("pasivaDesc").value = "";
    document.getElementById("defNombre").value = "";
    document.getElementById("defIcono").value = "";
    document.getElementById("defDesc").value = "";
    document.getElementById("contenedorArmas").innerHTML = "";
    document.getElementById("contenedorHabilidades").innerHTML = "";
    new bootstrap.Modal(document.getElementById("modalAnadir")).show();
});

// Función para crear una fila de arma o habilidad
function crearFilaHabilidad(contenedorId) {
    const contenedor = document.getElementById(contenedorId);
    const fila = document.createElement("div");
    fila.className = "row g-2 mb-2 align-items-center";
    fila.innerHTML = `
        <div class="col-md-4">
            <input type="text" class="form-control form-control-sm campo-nombre" placeholder="Nombre">
        </div>
        <div class="col-md-3">
            <input type="file" class="form-control form-control-sm campo-icono" accept="image/*">
        </div>
        <div class="col-md-4">
            <input type="text" class="form-control form-control-sm campo-desc" placeholder="Descripción">
        </div>
        <div class="col-md-1">
            <button class="btn btn-danger btn-sm w-100" onclick="this.closest('.row').remove()">✕</button>
        </div>`;
    contenedor.appendChild(fila);
}

document.getElementById("btnAddArma").addEventListener("click", () => crearFilaHabilidad("contenedorArmas"));
document.getElementById("btnAddHabilidad").addEventListener("click", () => crearFilaHabilidad("contenedorHabilidades"));

document.getElementById("btnConfirmarAnadir").addEventListener("click", () => {
    const nombre   = document.getElementById("nuevoNombre").value.trim();
        if (!nombre) {
            alert("El héroe debe tener al menos un nombre.");
            return;
        }
    const rol      = document.getElementById("nuevoRol").value;
    const vida     = parseInt(document.getElementById("nuevoVida").value) || 0;
    const desc     = document.getElementById("nuevoDesc").value.trim();
    const archivoPortada = document.getElementById("nuevoPortada").files[0];
    const portada = archivoPortada
        ? URL.createObjectURL(archivoPortada)
        : "https://placehold.co/300x200?text=" + encodeURIComponent(nombre);

    // Generar ID automáticamente desde el nombre
    const id = nombre.toLowerCase().split(" ").join("_");

    // Pasiva de rol según el rol elegido
    const pasivasRol = {
        tanque: { titulo: "Función: Tanque", icono: "Imagenes/habilidades_comunes/rol_tank.svg", descripcion: "Reduce los retrocesos y el dañocrítico recibido. Reduce la generación de definitiva por curación y daño recibido. Aumenta la salud base en los modos de juego de cola de roles." },
        dps:    { titulo: "Función: Daño",   icono: "Imagenes/habilidades_comunes/rol_dps.svg",  descripcion: "Dañar a un enemigo reduce temporalmente la curación que recibe." },
        apoyo:  { titulo: "Función: Apoyo",  icono: "Imagenes/habilidades_comunes/rol_supp.svg", descripcion: "Empieza a regenerar salud más rápidamente." }
    };

    const habilidades = [];

    // Añadir pasiva de rol automáticamente
    const pr = pasivasRol[rol];
    habilidades.push({ tipo: "pasivaRol", titulo: pr.titulo, icono: pr.icono, descripcion: pr.descripcion });

    // Pasiva propia (si se ha rellenado)
    const pasivaNombre = document.getElementById("pasivaNombre").value.trim();
    const pasivaIcono  = document.getElementById("pasivaIcono").value.trim();
    const pasivaDesc   = document.getElementById("pasivaDesc").value.trim();
    const pasivaArchivo = document.getElementById("pasivaIcono").files[0];
    const pasivaIcoUrl  = pasivaArchivo ? URL.createObjectURL(pasivaArchivo) : "";
    if (pasivaNombre) {
        habilidades.push({ tipo: "pasivaPropia", titulo: pasivaNombre, icono: pasivaIcoUrl, descripcion: pasivaDesc });
    }

    // Armas
    const filasArmas = document.getElementById("contenedorArmas").querySelectorAll(".row");
    for (let i = 0; i < filasArmas.length; i++) {
        const nom    = filasArmas[i].querySelector(".campo-nombre").value.trim();
        const archivo = filasArmas[i].querySelector(".campo-icono").files[0];
        const ico    = archivo ? URL.createObjectURL(archivo) : "";
        const des    = filasArmas[i].querySelector(".campo-desc").value.trim();
        if (nom) {
            habilidades.push({ tipo: "arma", titulo: nom, icono: ico, descripcion: des });
        }
    }

    // Habilidades normales
    const filasHab = document.getElementById("contenedorHabilidades").querySelectorAll(".row");
    for (let i = 0; i < filasHab.length; i++) {
        const nom     = filasHab[i].querySelector(".campo-nombre").value.trim();
        const archivo = filasHab[i].querySelector(".campo-icono").files[0];
        const ico     = archivo ? URL.createObjectURL(archivo) : "";
        const des     = filasHab[i].querySelector(".campo-desc").value.trim();
        if (nom) {
            habilidades.push({ tipo: "habilidad", titulo: nom, icono: ico, descripcion: des });
        }
    }

    // Definitiva
    const defNombre = document.getElementById("defNombre").value.trim();
    const defIcono  = document.getElementById("defIcono").value.trim();
    const defDesc   = document.getElementById("defDesc").value.trim();
    const defArchivo = document.getElementById("defIcono").files[0];
    const defIcoUrl  = defArchivo ? URL.createObjectURL(defArchivo) : "";
    if (defNombre) {
        habilidades.push({ tipo: "definitiva", titulo: defNombre, icono: defIcoUrl, descripcion: defDesc });
    }

    const nuevoHeroe = { id, nombre, rol, descripcion: desc, portada, vida, habilidades };

    fetch(API, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(nuevoHeroe)
    })
    .then(res => res.json())
    .then(h => {
        heroes.push(h);
        renderizar();
        bootstrap.Modal.getInstance(document.getElementById("modalAnadir")).hide();
    });
});


function abrirEditar(h) {
    document.getElementById("editarId").value = h.id;
    document.getElementById("editarNombre").value = h.nombre;
    document.getElementById("editarRol").value = h.rol;
    document.getElementById("editarVida").value = h.vida;
    document.getElementById("editarDesc").value = h.descripcion;
    new bootstrap.Modal(document.getElementById("modalEditar")).show();
}

document.getElementById("btnConfirmarEditar").addEventListener("click", () => {
    const id   = document.getElementById("editarId").value;
    const heroe = {
        id:          id,
        nombre:      document.getElementById("editarNombre").value.trim(),
        rol:         document.getElementById("editarRol").value,
        vida:        parseInt(document.getElementById("editarVida").value) || 0,
        descripcion: document.getElementById("editarDesc").value.trim(),
        portada:     heroes.find(h => h.id === id).portada,
        habilidades: heroes.find(h => h.id === id).habilidades
    };

    fetch(API + "/" + id, {
        method: "PUT",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(heroe)
    })
    .then(res => res.json())
    .then(actualizado => {
        for (let i = 0; i < heroes.length; i++) {
            if (heroes[i].id === id) {
                heroes[i] = actualizado;
                break;
            }
        }
        renderizar();
        bootstrap.Modal.getInstance(document.getElementById("modalEditar")).hide();
    });
});

// Vista general
function renderizarVistaGeneral() {
    const contenedor = document.getElementById("vistaGeneralContenido");
    contenedor.innerHTML = "";

    const roles = [
        { clave: "tanque", nombre: "Tanque", icono: "Imagenes/habilidades_comunes/rol_tank.svg" },
        { clave: "dps",    nombre: "Daño",   icono: "Imagenes/habilidades_comunes/rol_dps.svg"  },
        { clave: "apoyo",  nombre: "Apoyo",  icono: "Imagenes/habilidades_comunes/rol_supp.svg" }
    ];

    for (let r = 0; r < roles.length; r++) {
        const rol = roles[r];
        const lista = [];
        for (let i = 0; i < heroes.length; i++) {
            if (heroes[i].rol === rol.clave) {
                lista.push(heroes[i]);
            }
        }
        lista.sort((a, b) => a.nombre.localeCompare(b.nombre));

        const seccion = document.createElement("div");
        seccion.className = "mb-4";
        seccion.innerHTML = `
            <h6 class="text-center fw-bold mb-3" style="color:#e94560;letter-spacing:2px;">
                <img src="${rol.icono}" style="width:20px;height:20px;object-fit:contain;"> ${rol.nombre.toUpperCase()}
            </h6>
            <div class="d-flex flex-wrap justify-content-center gap-3" id="grupo-${rol.clave}"></div>
            <hr style="border-color:#0f3460;">`;
        contenedor.appendChild(seccion);

        const grupo = document.getElementById("grupo-" + rol.clave);
        for (let i = 0; i < lista.length; i++) {
            const h = lista[i];
            const item = document.createElement("div");
            item.className = "text-center";
            item.style.width = "70px";
            item.innerHTML = `
                <img src="${h.portada}" alt="${h.nombre}"
                     style="width:70px;height:70px;object-fit:cover;border-radius:50%;border:2px solid #0f3460;"
                     onerror="this.src='https://placehold.co/56x56?text=${encodeURIComponent(h.nombre[0])}'">
                <p style="font-size:0.70rem;margin-top:4px;color:#e0e0e0;word-break:break-word;">${h.nombre}</p>`;
            grupo.appendChild(item);
        }
    }
}

document.getElementById("btnVistaGeneral").addEventListener("click", () => {
    renderizarVistaGeneral();
    new bootstrap.Modal(document.getElementById("modalVistaGeneral")).show();
});