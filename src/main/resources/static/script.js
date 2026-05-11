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
    const pasivaPropia  = h.habilidades.find(hb => hb.tipo === "pasivaPropia");
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
    if (pasivaPropia) itemsSuperior.push({ ...pasivaPropia, esPropia: true });

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
        contenedorDef.innerHTML = `<p class="mb-1 fw-bold small" style="color:#e94560;">⚡ Habilidad Definitiva</p>`;
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
document.getElementById("btnAnadir").addEventListener("click", () =>
    new bootstrap.Modal(document.getElementById("modalAnadir")).show());

document.getElementById("btnConfirmarAnadir").addEventListener("click", () => {
    const nuevoHeroe = {
        id:          document.getElementById("nuevoId").value.trim(),
        nombre:      document.getElementById("nuevoNombre").value.trim(),
        rol:         document.getElementById("nuevoRol").value,
        descripcion: document.getElementById("nuevoDesc").value.trim(),
        portada:     "https://placehold.co/300x200?text=" + encodeURIComponent(document.getElementById("nuevoNombre").value),
        vida:        parseInt(document.getElementById("nuevoVida").value) || 0,
        habilidades: []
    };

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