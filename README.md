# 🦸 Galería de Héroes de Overwatch

Aplicación web para explorar, buscar y gestionar los héroes de **Overwatch**: su función, sus habilidades, su definitiva y sus pasivas.

Proyecto final de **1º de DAM** que junta las asignaturas de **Lenguaje de Marcas** y **Programación**: un frontend con HTML, CSS, JavaScript y Bootstrap que habla con una API REST hecha en **Spring Boot**, con los datos guardados en **PostgreSQL**.

<p>
  <img src="https://img.shields.io/badge/Java_21-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white" />
  <img src="https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white" />
  <img src="https://img.shields.io/badge/PostgreSQL-4169E1?style=for-the-badge&logo=postgresql&logoColor=white" />
  <img src="https://img.shields.io/badge/Bootstrap_5-7952B3?style=for-the-badge&logo=bootstrap&logoColor=white" />
  <img src="https://img.shields.io/badge/JavaScript-F7DF1E?style=for-the-badge&logo=javascript&logoColor=black" />
</p>

![Galería de héroes](docs/capturas/galeria.png)

## ✨ Qué hace

- 🗂️ **51 héroes** (14 tanques, 23 de daño y 14 de apoyo), cada uno con su descripción, vida, función secundaria y todas sus habilidades.
- 🔍 **Buscador y filtros** por nombre, rol y sub-rol, y orden alfabético.
- 🪟 **Ficha detallada** de cada héroe: armas, habilidades, definitiva y pasivas.
- ✏️ **CRUD completo**: añadir, editar y eliminar héroes desde la propia web.
- 🌗 **Modo claro y oscuro**.
- 📱 **Diseño adaptable** a móvil.
- 💾 Al arrancar por primera vez, la base de datos se rellena sola con todos los héroes.

## 📸 Capturas

| Pantalla de inicio | Ficha de un héroe |
|---|---|
| ![Inicio](docs/capturas/inicio.png) | ![Ficha de héroe](docs/capturas/detalle-heroe.png) |

| Modo claro | Móvil |
|---|---|
| ![Modo claro](docs/capturas/modo-claro.png) | <img src="docs/capturas/movil.png" alt="Versión móvil" width="260" /> |

## 🏗️ Cómo está hecho

```
src/main/java/dam/code/galeria_overwatch
├── controller/   → API REST (/heroes)
├── service/      → lógica de negocio
├── repository/   → acceso a datos con Spring Data JPA
└── model/        → entidades Heroe y Habilidad (relación 1:N)

src/main/resources/static
├── inicio.html   → pantalla de bienvenida
├── index.html    → galería
├── script.js     → consumo de la API, filtros, modales y CRUD
└── style.css     → estilos y modo claro/oscuro
```

### API REST

| Método | Ruta | Descripción |
|---|---|---|
| `GET` | `/heroes` | Lista todos los héroes |
| `GET` | `/heroes/{id}` | Devuelve un héroe |
| `POST` | `/heroes` | Crea un héroe |
| `PUT` | `/heroes/{id}` | Edita un héroe |
| `DELETE` | `/heroes/{id}` | Elimina un héroe |

## 🚀 Cómo ejecutarlo

**Requisitos:** Java 21 y PostgreSQL.

1. Crea la base de datos:
   ```sql
   CREATE DATABASE galeria_overwatch;
   ```
2. Indica tu usuario y contraseña de PostgreSQL con variables de entorno (si no las pones, usa `postgres` / `postgresql`):
   ```bash
   # Linux / macOS
   export DB_USER=postgres
   export DB_PASSWORD=tu_contraseña

   # Windows (PowerShell)
   $env:DB_USER="postgres"
   $env:DB_PASSWORD="tu_contraseña"
   ```
3. Arranca la aplicación:
   ```bash
   ./mvnw spring-boot:run
   ```
4. Abre **http://localhost:8080/inicio.html** 🎮

## ⚖️ Aviso

Proyecto de fans, hecho con fines educativos y sin ánimo de lucro. **Overwatch**, sus personajes, nombres e imágenes son propiedad de **Blizzard Entertainment, Inc.** Este proyecto no está afiliado ni respaldado por Blizzard.

---

Hecho por [Sergio Navarro (Colt246)](https://github.com/Colt246) · 1º DAM · Prometeo by ThePower
