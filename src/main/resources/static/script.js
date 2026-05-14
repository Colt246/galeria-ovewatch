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

    let lista = heroes.filter(h =>
        h.nombre.toLowerCase().includes(texto) &&
        (rol === "todos" || h.rol === rol)
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
        const col = document.createElement("div");
        col.className = "col";
        col.innerHTML = `
            <div class="tarjeta h-100" data-id="${h.id}">
                <img src="${h.portada}" alt="${h.nombre}"
                     onerror="this.src='https://placehold.co/300x200?text=${encodeURIComponent(h.nombre)}'">
                <div class="tarjeta-body">
                    <h6 class="mb-1">${h.nombre}</h6>
                    <span class="badge ${badgeClass}">${h.rol}</span>
                    <p class="small mt-2 mb-0">${h.descripcion}</p>
                </div>
            </div>`;
        col.querySelector(".tarjeta").addEventListener("click", () => abrirDetalle(h));
        galeria.appendChild(col);
    });
}

function abrirDetalle(h) {
    document.getElementById("modalNombre").textContent = h.nombre;
    document.getElementById("modalImg").src = h.portada;
    document.getElementById("modalDesc").textContent = h.descripcion;
    document.getElementById("modalVida").textContent = h.vida;

    document.getElementById("modalPasivaRol").innerHTML = "";
    document.getElementById("modalFilaSuperior").innerHTML = "";
    document.getElementById("modalHabilidades").innerHTML = "";
    document.getElementById("modalDefinitiva").innerHTML = "";

    if (!h.habilidades) {
        new bootstrap.Modal(document.getElementById("modalDetalle")).show();
        return;
    }

    const armas         = h.habilidades.filter(hb => hb.tipo === "arma");
    const pasivaRol     = h.habilidades.find(hb => hb.tipo === "pasivaRol");
    const pasivaPropias = h.habilidades.filter(hb => hb.tipo === "pasivaPropia");
    const habilidades   = h.habilidades.filter(hb => hb.tipo === "habilidad");
    const definitivas   = h.habilidades.filter(hb => hb.tipo === "definitiva");

    // Pasiva de rol
    if (pasivaRol) {
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