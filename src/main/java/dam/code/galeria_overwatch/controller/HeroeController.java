package dam.code.galeria_overwatch.controller;

import dam.code.galeria_overwatch.model.Habilidad;
import dam.code.galeria_overwatch.model.Heroe;
import dam.code.galeria_overwatch.service.HeroeService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class HeroeController {

    private final HeroeService service;

    public HeroeController(HeroeService service) {
        this.service = service;
        cargarHeroesIniciales();
    }

    private void cargarHeroesIniciales() {
        if (!service.listar().isEmpty()) return;

        // ── D.Va ──────────────────────────────────────────────────────────
        List<Habilidad> habDva = new ArrayList<>();
        habDva.add(new Habilidad("pasivaRol",     "Función: Tanque",    "Imagenes/habilidades_comunes/rol_tank.svg",  "Reduce los retrocesos y el dañocrítico recibido. Reduce la generación de definitiva por curación y daño recibido. Aumenta la salud base en los modos de juego de cola de roles."));
        habDva.add(new Habilidad("pasivaPropia",  "¡Eyección!",         "Imagenes/D.va/eyeccion.png",                 "Eyecta fuera del MECA cuando es destruido."));
        habDva.add(new Habilidad("arma",          "Cañones de fusión",  "Imagenes/D.va/cañon_fusion.png",             "Armas automáticas de corto alcance y dispersión."));
        habDva.add(new Habilidad("arma",          "Pistola de luz",     "Imagenes/D.va/pistola_luz.png",              "Arma automática."));
        habDva.add(new Habilidad("habilidad",     "Matriz de defensa",  "Imagenes/D.va/matrix.png",                   "Bloquea proyectiles en un área frente a ti."));
        habDva.add(new Habilidad("habilidad",     "Impulsores",         "Imagenes/D.va/boosters.png",                 "Vuela en la dirección en que estás mirando."));
        habDva.add(new Habilidad("habilidad",     "Micromisiles",       "Imagenes/D.va/micromisiles.png",             "Lanza una descarga de cohetes explosivos."));
        habDva.add(new Habilidad("definitiva",    "Autodestrucción",    "Imagenes/D.va/dva_bomb.png",                 "Expulsa al piloto y sobrecarga tu MECA, provocando que explote después de un corto periodo de tiempo."));
        habDva.add(new Habilidad("definitiva",    "MECA",               "Imagenes/D.va/call_mech.png",                "Después de que tu MECA haya sido destruido cae de nuevo a un nuevo MECA para subirse de nuevo."));
        service.guardar(new Heroe("dva", "D.Va", "tanque", "D.Va era una jugadora profesional que ahora aprovecha sus habilidades para pilotar un meca de última generación al servicio de su país.", "Imagenes/D.va/portada_dva.png", 650, habDva));

        // ── Domina ──────────────────────────────────────────────────────
        List<Habilidad> habDomina= new ArrayList<>();
        habDomina.add(new Habilidad("pasivaRol",    "Función: Tanque",       "Imagenes/habilidades_comunes/rol_tank.svg",   "Reduce los retrocesos y el dañocrítico recibido. Reduce la generación de definitiva por curación y daño recibido. Aumenta la salud base en los modos de juego de cola de roles."));
        habDomina.add(new Habilidad("pasivaPropia", "Reconstrucción",        "Imagenes/Domina/pasiva_domina.png",           "Inflingir daño con habilidades restaura escudos."));
        habDomina.add(new Habilidad("arma",         "Cañón de fotones",      "Imagenes/Domina/photon_magnum.png",           "Haz de alcance medio que culmina con un disparo de alto impacto."));
        habDomina.add(new Habilidad("habilidad",    "Matriz barrera",        "Imagenes/Domina/barrier_array.png",           "Construye una barrera segmentada."));
        habDomina.add(new Habilidad("habilidad",    "Repulsores sónicos",    "Imagenes/Domina/sonic_pulsor.png",            "Empuja hacia atrás a los enemigos, aturdiéndolos si golpean una pared."));
        habDomina.add(new Habilidad("habilidad",    "Carga de cristal",      "Imagenes/Domina/crystal.png",                 "Proyecta un cristal explosivo y lo reactiva para detonarlo."));
        habDomina.add(new Habilidad("definitiva",   "Panóptico",             "Imagenes/Domina/panopticon.png",              "Dispara una barrera de luz sólida que aprisiona a los jugadores y detona al acabar."));
        service.guardar(new Heroe("domina", "Domina", "tanque", "Como la negociadora más valiosa de Vishkar Corporation, Domina utiliza su dominio magistral de la luz sólida para tomar el control de cada situación.", "Imagenes/Domina/portada_domina.png", 650, habDomina));

        // ── Doomfist ──────────────────────────────────────────────────────
        List<Habilidad> habDoom = new ArrayList<>();
        habDoom.add(new Habilidad("pasivaRol",    "Función: Tanque",     "Imagenes/habilidades_comunes/rol_tank.svg", "Reduce los retrocesos y el dañocrítico recibido. Reduce la generación de definitiva por curación y daño recibido. Aumenta la salud base en los modos de juego de cola de roles."));
        habDoom.add(new Habilidad("pasivaPropia", "La mejor defensa...", "Imagenes/Doomfist/pasiva_doom.png",         "Inflingir daño con habilidades crea un exceso de salud temporal."));
        habDoom.add(new Habilidad("arma",         "Cañón de mano",       "Imagenes/Doomfist/cañon_mano.png",          "Arma de corto alcance con dispersión. Se recarga automáticamente."));
        habDoom.add(new Habilidad("habilidad",    "Puño cohete",         "Imagenes/Doomfist/punch.png",               "Mantén pulsado para cargar y suelta para lanzarte hacia delante y derribar al enemigo. El daño aumenta si el enemigo choca contra una pared."));
        habDoom.add(new Habilidad("habilidad",    "Golpe sísmico",       "Imagenes/Doomfist/slam_doom.png",           "Salta hacia delante y golpea el suelo."));
        habDoom.add(new Habilidad("habilidad",    "Bloqueo de poder",    "Imagenes/Doomfist/block_doom.png",          "Protégete de los ataques frontales. Bloquear daño fuerte potencia la habilidad Puño Cohete."));
        habDoom.add(new Habilidad("definitiva",   "Meteoro",             "Imagenes/Doomfist/meteor.png",              "Al pulsar la tecla de la definitiva el personaje salta y desapace. Mueve el área circular donde volverá a caer golpeando la zona objetivo. Se sana durante el tiempo que esté en el aire sin golpear el suelo."));
        service.guardar(new Heroe("doomfist", "Doomfist", "tanque", "Doomfist es el calculador líder de Talon, una organización terrorista y fuerza paramilitar que opera en contraposición a Overwatch.", "Imagenes/Doomfist/portada_doom.png", 525, habDoom));

        // ── Hazard ────────────────────────────────────────────────────────
        List<Habilidad> habHazard = new ArrayList<>();
        habHazard.add(new Habilidad("pasivaRol",    "Función: Tanque",     "Imagenes/habilidades_comunes/rol_tank.svg", "Reduce los retrocesos y el dañocrítico recibido. Reduce la generación de definitiva por curación y daño recibido. Aumenta la salud base en los modos de juego de cola de roles."));
        habHazard.add(new Habilidad("pasivaPropia", "Brinco",              "Imagenes/Hazard/brinco.png",                "Escala paredes cortas y se agarra a cornisas."));
        habHazard.add(new Habilidad("arma",         "Lanzaespinas",        "Imagenes/Hazard/arma_hazard.png",           "Dispara una ráfaga de púas."));
        habHazard.add(new Habilidad("habilidad",    "Protección de púas",  "Imagenes/Hazard/proteccion_puas.png",       "Protégete del daño frontal. Dispara púas teledirigidas a los enemigos cercanos y regenera munición."));
        habHazard.add(new Habilidad("habilidad",    "Salto violento",      "Imagenes/Hazard/salto_violento.png",        "Arremete hacia adelante. Actívalo de nuevo para cortar a los enemigos y empujarlos hacia atrás."));
        habHazard.add(new Habilidad("habilidad",    "Muro afilado",        "Imagenes/Hazard/muro_hazard.png",           "Lanza un muro con púas que daña y derriba a los enemigos cercanos."));
        habHazard.add(new Habilidad("definitiva",   "Aguacero",            "Imagenes/Hazard/hazard_ult.png",            "Hace llover un torrente de púas que inmovilizan a los enemigos."));
        service.guardar(new Heroe("hazard", "Hazard", "tanque", "Hazard, perturbador radical y arma imparable, se ha hecho famoso en el submundo criminal por luchar para acabar con el sistema.", "Imagenes/Hazard/portada_hazard.png", 650, habHazard));

        // ── Junker Queen ──────────────────────────────────────────────────
        List<Habilidad> habQueen = new ArrayList<>();
        habQueen.add(new Habilidad("pasivaRol",    "Función: Tanque",       "Imagenes/habilidades_comunes/rol_tank.svg",  "Reduce los retrocesos y el dañocrítico recibido. Reduce la generación de definitiva por curación y daño recibido. Aumenta la salud base en los modos de juego de cola de roles."));
        habQueen.add(new Habilidad("pasivaPropia", "Subida de adrenalina",  "Imagenes/Junker_Queen/pasiva_queen.png",     "Secura todo el daño a lo largo del tiempo unflingido por las heridas."));
        habQueen.add(new Habilidad("arma",         "Escopeta",              "Imagenes/Junker_Queen/escopeta_queen.png",   "Escopeta de corredera."));
        habQueen.add(new Habilidad("habilidad",    "Grito de Mando",        "Imagenes/Junker_Queen/grito_mando.png",      "Otorga salud temporal y velocidad de movimiento a ti y a tus aliados."));
        habQueen.add(new Habilidad("habilidad",    "Matanza",               "Imagenes/Junker_Queen/hacha.png",            "Hiere a todos los enemigos frente a ti, lo que inflige daño a lo largo del tiempo y reduce el tiempo de recuperación de cada enemigo golpeado."));
        habQueen.add(new Habilidad("definitiva",   "Masacre",               "Imagenes/Junker_Queen/rampage.png",          "Carga hacia adelante. Hiere a los enemigos, infligiendo daño prolongado e impidiendo su curación."));
        service.guardar(new Heroe("junkerQueen", "Junker Queen", "tanque", "Tanque diseñada para el combate cuerpo a cuerpo. Muchas de sus habilidades inflingen heridas que hacen que los enenmigos pierdan salud lentamente.", "Imagenes/Junker_Queen/portada_queen.png", 525, habQueen));

        // ── Mauga ─────────────────────────────────────────────────────────
        List<Habilidad> habMauga = new ArrayList<>();
        habMauga.add(new Habilidad("pasivaRol",    "Función: Tanque",              "Imagenes/habilidades_comunes/rol_tank.svg",  "Reduce los retrocesos y el dañocrítico recibido. Reduce la generación de definitiva por curación y daño recibido. Aumenta la salud base en los modos de juego de cola de roles."));
        habMauga.add(new Habilidad("pasivaPropia", "Berserker",                    "Imagenes/Mauga/pasiva_mauga.png",            "Obtienes salud temporal al inflingir daño crítico."));
        habMauga.add(new Habilidad("arma",         "Cañón de cadena incendiario",  "Imagenes/Mauga/arma_mauga_fuego.png",        "Arma automática que enciende a los enemigos con impactos repetidos."));
        habMauga.add(new Habilidad("arma",         "Cañón de cadena volátil",      "Imagenes/Mauga/arma_mauga_critico.png",      "Arma automática que inflige daño crítico a los enemigos en llamas."));
        habMauga.add(new Habilidad("habilidad",    "Arrollar",                     "Imagenes/Mauga/arrollar_mauga.png",          "Embistes y das un pisotón para lanzar a los enemigos por los aires. Eres imparable mientras embites."));
        habMauga.add(new Habilidad("habilidad",    "Sobreestimulación cardíaca",   "Imagenes/Mauga/cardiac.png",                 "Otorga reducción de daño y los aliados cercanos se sanan al inflingir daño."));
        habMauga.add(new Habilidad("definitiva",   "Mano a mano",                  "Imagenes/Mauga/cage.png",                    "Despliegas una barrera que os encierra a ti y a los enemigos."));
        service.guardar(new Heroe("mauga", "Mauga", "tanque", "Mauga, guerrero samoano carismático y astuto como pocos, se abre paso entre el caos del campo de batalla y vive cada día como si fuera el último.", "Imagenes/Mauga/portada_mauga.png", 725, habMauga));

        // ── Anran ──────────────────────────────────────────────────────────
        List<Habilidad> habAnran = new ArrayList<>();
        habAnran.add(new Habilidad("pasivaRol",    "Función: Daño",          "Imagenes/habilidades_comunes/rol_dps.svg",     "Dañar a un enemigo reduce temporalmente la curación que recibe."));
        habAnran.add(new Habilidad("pasivaPropia", "Ignición",               "Imagenes/Anran/ignicion.png",                  "Golpea a los enemigos con ataques de fuego para quemarlos."));
        habAnran.add(new Habilidad("arma",         "Abanicos Zhuque",        "Imagenes/Anran/abanicos.png",                  "Abanicos que disparan proyectiles ardientes."));
        habAnran.add(new Habilidad("arma",         "Atizar el fuego",        "Imagenes/Anran/avivar.png",                    "Una explosión de aire caliente que aumenta el daño por quemadura."));
        habAnran.add(new Habilidad("habilidad",    "Carga infernal",         "Imagenes/Anran/carga_infernal.png",            "Te impulsa hacia delante y daña a los enemigos."));
        habAnran.add(new Habilidad("habilidad",    "Llama danzante",         "Imagenes/Anran/llama.png",                     "Golpea a los enemigos cercanos mientas esquivas y te sanas por cada enemigo golpeado."));
        habAnran.add(new Habilidad("definitiva",   "Ascenso bermellón",      "Imagenes/Anran/ascenso_bermellon.png",         "Cargas hacia delante, explota al impactar y prende a los enemigos inmediatamente."));
        habAnran.add(new Habilidad("definitiva",   "Renacimiento bermellón", "Imagenes/Anran/renacimiento.png",              "Cuando mueres, te revive con una explosión abrasadora."));
        service.guardar(new Heroe("anran", "Anran", "dps", "Anran, la alumna más destacada de la Escuela de Bomberos de la Universidad de Wuxing, siempre está ansiosa por superar sus límites.", "Imagenes/Anran/portada_anran.png", 250, habAnran));

        // ── Ashe ──────────────────────────────────────────────────────────
        List<Habilidad> habAshe = new ArrayList<>();
        habAshe.add(new Habilidad("pasivaRol",  "Función: Daño", "Imagenes/habilidades_comunes/rol_dps.svg",       "Dañar a un enemigo reduce temporalmente la curación que recibe."));
        habAshe.add(new Habilidad("arma",       "Víbora",        "Imagenes/Ashe/vibora.png",                       "Rifle semiautomátco."));
        habAshe.add(new Habilidad("arma",       "Encañonar",     "Imagenes/habilidades_comunes/apuntado_zoom.png", "Mantén pulsado para acercar el zoom, lo que aumenta el daño y la precisión, pero reduce la cadencia de fuego."));
        habAshe.add(new Habilidad("habilidad",  "Recortada",     "Imagenes/Ashe/coach.png",                        "Acribillas a los enemigos enfrente de ti y te implusa hacia atrás."));
        habAshe.add(new Habilidad("habilidad",  "Dinamita",      "Imagenes/Ashe/dinamita.png",                     "Lanzas un explosivo que detona trás un breve periodo o al instante si le disparas."));
        habAshe.add(new Habilidad("definitiva", "BOB",           "Imagenes/Ashe/bob.png",                          "Despliegas un Bob, que carga hacia delante y lanza a los enemigos por los aires. Luego ataca con los cañones de su brazo."));
        service.guardar(new Heroe("ashe", "Ashe", "dps", "Ashe es la ambiciosa y calculadora líder de la banda Deadlock Rebels y una figura respetada en el mundo criminal de los bajos fondos.", "Imagenes/Ashe/portada_ashe.png", 250, habAshe));

        // ── Bastión ───────────────────────────────────────────────────────
        List<Habilidad> habBastion = new ArrayList<>();
        habBastion.add(new Habilidad("pasivaRol",     "Función: Daño",          "Imagenes/habilidades_comunes/rol_dps.svg",    "Dañar a un enemigo reduce temporalmente la curación que recibe."));
        habBastion.add(new Habilidad("pasivaPropia",  "Acorazado",              "Imagenes/Bastion/pasiva_bastion.png",         "Reduce el daño recibido mientras está transformado."));
        habBastion.add(new Habilidad("arma",          "Modo: Reconocimiento",   "Imagenes/Bastion/arma_bastion.png",           "Móvil, con un arma ligera y de gran precisión."));
        habBastion.add(new Habilidad("arma",          "Granada táctica A-36",   "Imagenes/Bastion/granada_bastion.png",        "Dispara una bomba que rebota en las paredes y explota cuando golpea a los enemigos o al suelo."));
        habBastion.add(new Habilidad("habilidad",     "Reconfiguración",        "Imagenes/Bastion/reconfiguracion.png",        "Cambiar entre configuraciones de armas."));
        habBastion.add(new Habilidad("habilidad",     "Modo: Asalto",           "Imagenes/Bastion/modo_asalto_bastion.png",    "Un tanque de movimiento lento con un poderoso cañón giratorio."));
        habBastion.add(new Habilidad("definitiva",    "Modo: Artillería",       "Imagenes/Bastion/bastion_ult.png",            "Queda inmóvil y dispara hasta tres potentes proyectiles de artillería."));
        service.guardar(new Heroe("bastion", "Bastión", "dps", "Antaño un combatiente de primera línea durante la devastadora Crisis Ómnica, ahora esta curiosa unidad Bastion se dedica a explorar el mundo. Le fascina la naturaleza, pero mantiene las distancias con una humanidad que aún recela de los robots.", "Imagenes/Bastion/portada_bastion.png", 350, habBastion));

        // ── Cassidy ───────────────────────────────────────────────────────
        List<Habilidad> habCassidy = new ArrayList<>();
        habCassidy.add(new Habilidad("pasivaRol",    "Función: Daño",                       "Imagenes/habilidades_comunes/rol_dps.svg",   "Dañar a un enemigo reduce temporalmente la curación que recibe."));
        habCassidy.add(new Habilidad("arma",         "Pacificador",                         "Imagenes/Cassidy/arma_cass.png",             "Revólver preciso y potente."));
        habCassidy.add(new Habilidad("arma",         "Fuego alternativo del Pacificador",   "Imagenes/Cassidy/alt_shot_cass.png",         "Dispara salvajemente las rondas restantes."));
        habCassidy.add(new Habilidad("habilidad",    "Evasión",                             "Imagenes/Cassidy/combat_roll.png",           "Rueda en la dirección en la que te mueves para recibir menos daño y recargar."));
        habCassidy.add(new Habilidad("habilidad",    "Granada aturdidora",                  "Imagenes/Cassidy/flash_bang.png",            "Obstaculiza a los enemigos que están frente a ti, ralentizándolos y evitando que usen habilidades de movimiento."));
        habCassidy.add(new Habilidad("definitiva",   "Sin perdón",                          "Imagenes/Cassidy/high_noon.png",             "Enfréntate a tus enemigos. Pulsa para fijar el objetivo y luego para disparar."));
        service.guardar(new Heroe("cassidy", "Cassidy", "dps", "Armado con su revólver Peacekeeper (Pacificador) el forajido Cole Cassidy imparte justicia a su manera.", "Imagenes/Cassidy/portada_cass.png", 250, habCassidy));

        // ── Echo ──────────────────────────────────────────────────────────
        List<Habilidad> habEcho = new ArrayList<>();
        habEcho.add(new Habilidad("pasivaRol",      "Función: Daño",    "Imagenes/habilidades_comunes/rol_dps.svg",   "Dañar a un enemigo reduce temporalmente la curación que recibe."));
        habEcho.add(new Habilidad("pasivaPropia",   "Planeo",           "Imagenes/Echo/echo_glide.png",               "Mantén pulsado el botón de salto mientras caes para planear."));
        habEcho.add(new Habilidad("arma",           "Disparo triple",   "Imagenes/Echo/tri_shot.png",                 "Lanza 3 disparos a la vez en un patrón triangular."));
        habEcho.add(new Habilidad("habilidad",      "Bombas lapa",      "Imagenes/Echo/sticky_bombs.png",             "Lanza una salva de bombas lapa que explotan tras unos instantes."));
        habEcho.add(new Habilidad("habilidad",      "Vuelo",            "Imagenes/Echo/echo_flight.png",              "Vuela rápidamente hacia delante y luego planea con libertad durante unos instantes."));
        habEcho.add(new Habilidad("habilidad",      "Haz enfocado",     "Imagenes/Echo/echo_beam.png",                "Canaliza un haz durante unos segundos. Inflinge un gran daño a los objetivos con menos de la mitad de salud."));
        habEcho.add(new Habilidad("definitiva",     "Duplicado",        "Imagenes/Echo/copy.png",                     "Te combiertes en una copia del héroe enemigo seleccionado, que no puede camabiar el héroe mientras dure el efecto."));
        service.guardar(new Heroe("echo", "Echo", "dps", "Echo es una robot polivalente y adaptable con la inteligencia artificial más sofisticada del mundo. El diseño fue obra de la doctora Mina Liao para las misiones de combate de Overwatch.", "Imagenes/Echo/portada_echo.png", 225, habEcho));

        // ── Emre ──────────────────────────────────────────────────────────
        List<Habilidad> habEmre = new ArrayList<>();
        habEmre.add(new Habilidad("pasivaRol",   "Función: Daño",              "Imagenes/habilidades_comunes/rol_dps.svg",       "Dañar a un enemigo reduce temporalmente la curación que recibe."));
        habEmre.add(new Habilidad("pasivaPropia","Vitales alterados",          "Imagenes/Emre/vitals.png",                       "La regeneración pasiva de salud se activa antes y restaura inmediatamente 30 puntos de salud cuando se activa."));
        habEmre.add(new Habilidad("arma",        "Rifle de rafaga sintética",  "Imagenes/Emre/burst_rifle.png",                  "Un arma que dispara ráfagas de tres."));
        habEmre.add(new Habilidad("arma",        "Apuntado",                   "Imagenes/habilidades_comunes/apuntado_2.png",    "Mantén pulsado para acercar el zoom, lo que aumenta la precisión y el alcance de caída."));
        habEmre.add(new Habilidad("habilidad",   "Pistola sifonadora",         "Imagenes/Emre/siphon_pistol.png",                "Empuña temporalmente una pistola semiautomática con balas explosivas que roban vida. Muévete más rápido y salta más alto mientras la empuñas."));
        habEmre.add(new Habilidad("habilidad",   "Granada cibernética",        "Imagenes/Emre/frag.png",                         "Lanza una granada que detona tras rebotar brevemente."));
        habEmre.add(new Habilidad("definitiva",  "Protocolo de anulación",     "Imagenes/Emre/override_protocol.png",                         "Se inicia una anulación, transformándote en un arma viva."));
        service.guardar(new Heroe("emre", "Emre", "dps", "Emre desapareció tras una exitosa etapa en el equipo de asalto de Overwatch. Ha reaparecido años después, con su cuerpo y mente manipulados por algo desconocido.", "Imagenes/Emre/portada_emre.png", 250, habEmre));

        // ── Freja ─────────────────────────────────────────────────────────
        List<Habilidad> habFreja = new ArrayList<>();
        habFreja.add(new Habilidad("pasivaRol",   "Función: Daño",        "Imagenes/habilidades_comunes/rol_dps.svg",  "Dañar a un enemigo reduce temporalmente la curación que recibe."));
        habFreja.add(new Habilidad("pasivaPropia","Caza recompensas",     "Imagenes/Freja/pasiva_freja.png",           "Cada 3 golpes finales, obtienes carga definitiva adicional."));
        habFreja.add(new Habilidad("arma",        "Ballesta rapaz",       "Imagenes/Freja/ballesta.png",               "Dispara rápidamente cerrojos automáticos."));
        habFreja.add(new Habilidad("arma",        "Apuntado",             "Imagenes/Freja/apuntado_freja.png",         "Reduce tu velocidad para apuntar con un rayo explosivo de alta velocidad. Usar Carrera Rápida actualiza Apuntar."));
        habFreja.add(new Habilidad("habilidad",   "Desplazamiento veloz", "Imagenes/Freja/freja_dash.png",             "Salta en la dirección en la que te mueves y actualiza Apuntar."));
        habFreja.add(new Habilidad("habilidad",   "Corriente ascendente", "Imagenes/Freja/corriente_ascendente.png",   "Despegue hacia arriba con una ráfaga de viento."));
        habFreja.add(new Habilidad("definitiva",  "Disparo de boleadora", "Imagenes/Freja/bola_shot.png",              "Dispara una bola explosiva. Al impactar a un enemigo, lo envuelve y atrae a otros enemigos cercanos."));
        service.guardar(new Heroe("freja", "Freja", "dps", "Una antigua rescatista convertida en cazarrecompensas, Freja puede encontrar a cualquiera por el precio adecuado.", "Imagenes/Freja/portada_freja.png", 225, habFreja));

        // ── Genji ─────────────────────────────────────────────────────────
        List<Habilidad> habGenji = new ArrayList<>();
        habGenji.add(new Habilidad("pasivaRol",   "Función: Daño",                 "Imagenes/habilidades_comunes/rol_dps.svg",  "Dañar a un enemigo reduce temporalmente la curación que recibe."));
        habGenji.add(new Habilidad("pasivaPropia","Ciberagilidad",                 "Imagenes/Genji/pasiva_genji.png",           "Escala paredes y tiene doble salto."));
        habGenji.add(new Habilidad("arma",        "Shuriken",                      "Imagenes/Genji/shuriken.png",               "Lanza una ráfaga precisa de 3 proyectiles."));
        habGenji.add(new Habilidad("arma",        "Shuriken disparo alternativo",  "Imagenes/Genji/shuriken.png",               "Lanza 3 proyectiles en un arco."));
        habGenji.add(new Habilidad("habilidad",   "Corte veloz",                   "Imagenes/Genji/dash_genji.png",             "Carga rápidamente hacia delante y dañas a los enemigos. Las eliminaciones reinician el tiempo de reutilización."));
        habGenji.add(new Habilidad("habilidad",   "Desvío",                        "Imagenes/Genji/deflect.png",                "Desvías los proyectiles recibidos hacia la dirección en la que miras y bloqueas ataques cuerpo a cuerpo."));
        habGenji.add(new Habilidad("definitiva",  "Hoja del dragón",               "Imagenes/Genji/dragon_blade.png",           "Desenfundas un arma cuerpo a cuerpo mortifera."));
        service.guardar(new Heroe("genji", "Genji", "dps", "El cíborg ninja Genji Shimada ha aceptado el cuerpo potenciado que rechazó en el pasado y, gracias a ello, ha descubierto una humanidad superior.", "Imagenes/Genji/portada_genji.png", 250, habGenji));

        // ── Hanzo ─────────────────────────────────────────────────────────
        List<Habilidad> habHanzo = new ArrayList<>();
        habHanzo.add(new Habilidad("pasivaRol",   "Función: Daño",      "Imagenes/habilidades_comunes/rol_dps.svg", "Dañar a un enemigo reduce temporalmente la curación que recibe."));
        habHanzo.add(new Habilidad("pasivaPropia","Escalada de pared",  "Imagenes/Hanzo/escalada_hanzo.png",        "Saltas hacia una pared para trepar por ella."));
        habHanzo.add(new Habilidad("arma",        "Arco de tormenta",   "Imagenes/Hanzo/arco.png",                  "Mantenlo pulsado para cargar las flechas, y luego suéltalo para dispararlas más lejos."));
        habHanzo.add(new Habilidad("habilidad",   "Tormenta de flechas","Imagenes/Hanzo/storm_arrow.png",           "Las siguentes 5 flechas rebotan, se lanzan de forma instantánea e inflingen daño reducido."));
        habHanzo.add(new Habilidad("habilidad",   "Flecha sónica",      "Imagenes/Hanzo/sonic_arrow.png",           "Tras impactar, revela a los enemigos durante un breve período de tiempo."));
        habHanzo.add(new Habilidad("habilidad",   "Agilidad del dragón","Imagenes/Hanzo/salto_extra_hanzo.png",     "Tiene doble salto."));
        habHanzo.add(new Habilidad("definitiva",  "Ataque del dragón",  "Imagenes/Hanzo/dragons.png",               "Lanzas un espíritu dragón letal que arrastra con los enemígos que atraviesa."));
        service.guardar(new Heroe("hanzo", "Hanzo", "dps", "Hanzo Shimada no deja de poner a prueba sus habilidades como arquero y asesino para convertirse en un guerrero sin par.", "Imagenes/Hanzo/portada_hanzo.png", 250, habHanzo));

        // ── Junkrat ───────────────────────────────────────────────────────
        List<Habilidad> habJunkrat = new ArrayList<>();
        habJunkrat.add(new Habilidad("pasivaRol",   "Función: Daño",    "Imagenes/habilidades_comunes/rol_dps.svg", "Dañar a un enemigo reduce temporalmente la curación que recibe."));
        habJunkrat.add(new Habilidad("pasivaPropia","Caos total",       "Imagenes/Junkrat/pasiva_junkrat.png",      "No sufres daño con tus propios explosivos. Sueltas bombas al morir."));
        habJunkrat.add(new Habilidad("arma",        "Lanzagranadas",    "Imagenes/Junkrat/arma_junkrat.png",        "Arma de proyectiles explosivos que rebotan."));
        habJunkrat.add(new Habilidad("habilidad",   "Mina de conmoción","Imagenes/Junkrat/mina_junkrat.png",        "Lanzas una mina que repeles y detonas."));
        habJunkrat.add(new Habilidad("habilidad",   "Cepo",             "Imagenes/Junkrat/cepo.png",                "Colocas una trampa inmovilizadora."));
        habJunkrat.add(new Habilidad("definitiva",  "Rueda explosiva",  "Imagenes/Junkrat/rip_tire.png",            "Dirige y detonas una rueda explosiva."));
        service.guardar(new Heroe("junkrat", "Junkrat", "dps", "Junkrat es un demoledor fanático de los explosivos que disfruta con el caos y la destrucción.", "Imagenes/Junkrat/portada_junkrat.png", 250, habJunkrat));

        // ── Mei ───────────────────────────────────────────────────────
        List<Habilidad> habMei = new ArrayList<>();
        habMei.add(new Habilidad("pasivaRol",   "Función: Daño",          "Imagenes/habilidades_comunes/rol_dps.svg",  "Dañar a un enemigo reduce temporalmente la curación que recibe."));
        habMei.add(new Habilidad("arma",        "Pistola endotérmica",    "Imagenes/Mei/blaster.png",                  "Arma de rociado de corto alcance que realentiza a los enemigos."));
        habMei.add(new Habilidad("arma",        "Carámbano",              "Imagenes/Mei/carambano.png",                "Lanzacarámbanos de largo alcance."));
        habMei.add(new Habilidad("habilidad",   "Criónica",               "Imagenes/Mei/cube.png",                     "Te vuelves invulnerable y te sanas."));
        habMei.add(new Habilidad("habilidad",   "Muro de Hielo",          "Imagenes/Mei/ice_wall.png",                 "Creas un muro de hielo."));
        habMei.add(new Habilidad("definitiva",  "Ventisca",               "Imagenes/Mei/blizzard.png",                 "Lanzas un dron de control climático que congela a los enemigos en una gran área."));
        service.guardar(new Heroe("mei", "Mei", "dps", "Mei es una científica que ha tomado en sus propias manos la lucha por preservar el medio ambiente.", "Imagenes/Mei/portada_mei.png", 300, habMei));

        // ── Ana ───────────────────────────────────────────────────────────
        List<Habilidad> habAna = new ArrayList<>();
        habAna.add(new Habilidad("pasivaRol",  "Función: Apoyo",  "Imagenes/habilidades_comunes/rol_supp.svg",      "Empieza a regenerar salud más rápidamente."));
        habAna.add(new Habilidad("arma",       "Rifle biótico",   "Imagenes/Ana/rifle_biotico.png",                 "Rifle de gran alcance que sana a los aliados y daña a los enemigos."));
        habAna.add(new Habilidad("arma",       "Zoom",            "Imagenes/habilidades_comunes/apuntado_zoom.png", "Mantén pulsado para acercar el zoom."));
        habAna.add(new Habilidad("habilidad",  "Dardo Sedante",   "Imagenes/Ana/sleep.png",                         "Dispara un dardo que duerme al enemigo."));
        habAna.add(new Habilidad("habilidad",  "Granada Biótica", "Imagenes/Ana/nade.png",                          "Lanzas una bomba que sana y aumenta la sanación a los aliados; al mismo tiempo, inflinge daño u evita que se puedan sanar los enemigos."));
        habAna.add(new Habilidad("definitiva", "Nanoestimulante", "Imagenes/Ana/nano.png",                          "Aumenta el daño de un aliado, al tiempo que reduces el daño que este recibe."));
        service.guardar(new Heroe("ana", "Ana", "apoyo", "Ana, una de las fundadoras de Overwatch, usa sus habilidades y experiencia para proteger su hogar y a todos los que le importan.", "Imagenes/Ana/portada_ana.png", 250, habAna));

        // ── Baptiste ──────────────────────────────────────────────────────
        List<Habilidad> habBap = new ArrayList<>();
        habBap.add(new Habilidad("pasivaRol",    "Función: Apoyo",                            "Imagenes/habilidades_comunes/rol_supp.svg", "Empieza a regenerar salud más rápidamente."));
        habBap.add(new Habilidad("pasivaPropia", "Exo botas",                                 "Imagenes/Baptiste/exo_botas.png",           "Mantén la posición agachada para saltar más alto."));
        habBap.add(new Habilidad("arma",         "Lanzagranadas biótico",                     "Imagenes/Baptiste/arma_bap.png",            "Pistola de ráfaga de tres disparos."));
        habBap.add(new Habilidad("arma",         "Lanzagranadas biótico disparo alternativo", "Imagenes/Baptiste/bap_alt_shot.png",        "Lanza un proyectil curativo que cura a todos los aliados cercanos al impacto."));
        habBap.add(new Habilidad("habilidad",    "Energía regeneradora",                      "Imagenes/Baptiste/energia_reg.png",         "Actívalo para curarte a ti mismo y a tus aliados cercanos al instante, con curación adicional con el tiempo. La curación instantánea se duplica para objetivos con menos de la mitad de su salud."));
        habBap.add(new Habilidad("habilidad",    "Campo de inmortalidad",                     "Imagenes/Baptiste/lamp.png",                "Lanza un dispositivo que impide que los aliados mueran. El dispositivo puede destruirse."));
        habBap.add(new Habilidad("definitiva",   "Matriz amplificadora",                      "Imagenes/Baptiste/window.png",              "Proyecta una matriz que duplica el daño y la curación de los proyectiles aliados."));
        service.guardar(new Heroe("baptiste", "Baptiste", "apoyo", "Baptiste es un médico de combate y exagente de Talon que ahora usa sus habilidades para ayudar a las víctimas de la guerra.", "Imagenes/Baptiste/portada_bap.png", 250, habBap));

        // ── Brigitte ──────────────────────────────────────────────────────
        List<Habilidad> habBrig = new ArrayList<>();
        habBrig.add(new Habilidad("pasivaRol",     "Función: Apoyo",        "Imagenes/habilidades_comunes/rol_supp.svg", "Empieza a regenerar salud más rápidamente."));
        habBrig.add(new Habilidad("pasivaPropia",  "Inspiración",           "Imagenes/Brigitte/pasiva_brig.png",         "Infligir daño a los enemigos cura a los aliados cercanos."));
        habBrig.add(new Habilidad("arma",          "Mangual mecánico",      "Imagenes/Brigitte/mangual_mecanico.png",    "Arma cuerpo a cuerpo con alcance extendido."));
        habBrig.add(new Habilidad("habilidad",     "Escudo barrera",        "Imagenes/Brigitte/escudo_barrera.png",      "Mantenga presionado para desplegar una barrera de energía frontal."));
        habBrig.add(new Habilidad("habilidad",     "Carga con escudo",      "Imagenes/Brigitte/carga_escudo.png",        "Disponible al desplegar el Escudo Barrera. Avanza rápidamente para derribar a un enemigo."));
        habBrig.add(new Habilidad("habilidad",     "Lanzamiento de mangual","Imagenes/Brigitte/lanzamiento_mangual.png", "Lanza tu mayal hacia adelante para derribar a un enemigo y alejarlo de ti."));
        habBrig.add(new Habilidad("habilidad",     "Kit de reparación",     "Imagenes/Brigitte/pack.png",                "Cura a un aliado durante un breve periodo."));
        habBrig.add(new Habilidad("definitiva",    "Formación",             "Imagenes/Brigitte/rally.png",               "Obtén armadura, potencia el escudo de barrera y proporciona salud adicional a los aliados cercanos."));
        service.guardar(new Heroe("brigitte", "Brigitte", "apoyo", "Cansada de estar de brazos cruzados, Brigitte Lindholm se ha alzado en armas para proteger a aquellos que la necesitan.", "Imagenes/Brigitte/portada_brig.png", 250, habBrig));

        // ── Illari ────────────────────────────────────────────────────────
        List<Habilidad> habIllari = new ArrayList<>();
        habIllari.add(new Habilidad("pasivaRol",  "Función: Apoyo",                   "Imagenes/habilidades_comunes/rol_supp.svg",   "Empieza a regenerar salud más rápidamente."));
        habIllari.add(new Habilidad("arma",       "Rifle solar",                      "Imagenes/Illari/rifle_solar.png",             "Rifle de largo alcance con carga automática."));
        habIllari.add(new Habilidad("arma",       "Rifle solar disparo alternativo",  "Imagenes/Illari/illari_alt_shot.png",         "Rayo curativo de medio alcance que consume energía solar."));
        habIllari.add(new Habilidad("habilidad",  "Helioterapia",                     "Imagenes/Illari/torreta_illari.png",          "Despliega una torreta que sana a los aliados."));
        habIllari.add(new Habilidad("habilidad",  "Erupción",                         "Imagenes/Illari/erupcion.png",                "Te lanzas en la dirección en la que te estás moviendo y repelas a los enemigos. Mantén pulsado para ascender más alto."));
        habIllari.add(new Habilidad("definitiva", "Sol cautivo",                      "Imagenes/Illari/sun.png",                     "Dispara una bola explosiva de energía solar. Los enemigos alcanzados quedan ralentizados y explotan después de recibir mucho daño."));
        service.guardar(new Heroe("illari", "Illari", "apoyo", "Como la última de los guerreros Inti, Illari es un recipiente para el poder del sol. Hará lo que sea posible para compensar su pasado.", "Imagenes/Illari/portada_illari.png", 250, habIllari));

        // ── Jetpack Cat ────────────────────────────────────────────────────────
        List<Habilidad> habCat = new ArrayList<>();
        habCat.add(new Habilidad("pasivaRol",      "Función: Apoyo",             "Imagenes/habilidades_comunes/rol_supp.svg",     "Empieza a regenerar salud más rápidamente."));
        habCat.add(new Habilidad("pasivaPropia",   "Mochila propulsora",         "Imagenes/Cat/jetpack.png",                      "Vuelo permanente."));
        habCat.add(new Habilidad("arma",           "Patiproyectiles bióticos",   "Imagenes/Cat/biotic_pawjectiles.png",           "Expansión de proyectiles a distancia media que sanan aliados o dañan enemigos."));
        habCat.add(new Habilidad("habilidad",      "Vuelo frenético",            "Imagenes/Cat/frenetic_flight.png",              "Acelera en dirección a tu movimiento. La recuperación de combustible se realiza al llevar a otro jugador."));
        habCat.add(new Habilidad("habilidad",      "Línea de vida",              "Imagenes/Cat/lifeline.png",                     "Activa el modo transporte, lo que permite remolcar a un aliado. Aumenta la velocidad de movimiento y sana a tu aliado."));
        habCat.add(new Habilidad("habilidad",      "Ronroneo",                   "Imagenes/Cat/purr.png",                         "Sanación de zona pulsante que aumenta en frecuencia con el tiempo. Repele a los enemigos cercanos cuando se activa."));
        habCat.add(new Habilidad("definitiva",     "Gata secuestradora",         "Imagenes/Cat/catnapper.png",                    "Lánzate hacia un punto del suelo, derribando a enemigos y atrapando al más cercano a ti."));
        service.guardar(new Heroe("cat", "Jetpack Cat", "apoyo", "Jetpack Cat, un intrépido piloto felino equipado con el último invento de propulsión a chorro de Brigitte, aporta un adorable apoyo aéreo al campo de batalla.", "Imagenes/Cat/portada_jetpack_cat.png", 225, habCat));

        // ── Juno ──────────────────────────────────────────────────────────
        List<Habilidad> habJuno = new ArrayList<>();
        habJuno.add(new Habilidad("pasivaRol",      "Función: Apoyo",     "Imagenes/habilidades_comunes/rol_supp.svg",   "Empieza a regenerar salud más rápidamente."));
        habJuno.add(new Habilidad("pasivaPropia",   "Botas marcianas",    "Imagenes/Juno/botas_marcianas.png",           "Mientras esté en el aire, presiona el botón de salto para realizar un segundo salto y mantén presionado para flotar."));
        habJuno.add(new Habilidad("arma",           "Mediblaster",        "Imagenes/Juno/mediblaster.png",               "Arma de fuego explosivo que cura a los aliados y daña a los enemigos."));
        habJuno.add(new Habilidad("habilidad",      "Torpedos pulsar",    "Imagenes/Juno/torpedos_pulsar.png",           "Presiona para fijar al objetivo y luego dispara los proyectiles teledirigidos. Cura a los aliados con el tiempo y daña a los enemigos."));
        habJuno.add(new Habilidad("habilidad",      "Hiperanillo",        "Imagenes/Juno/hiperanillo.png",               "Despliega un anillo que aumenta la velocidad de movimiento de los aliados que pasan a través de él."));
        habJuno.add(new Habilidad("habilidad",      "Impulso de planeo",  "Imagenes/Juno/impulso_planeo.png",            "Deslízate horizontalmente con mayor velocidad de movimiento."));
        habJuno.add(new Habilidad("definitiva",     "Rayo orbital",       "Imagenes/Juno/orbit_ray.png",                 "Invoca un rayo que viaja hacia adelante, curando a los aliados y aumentando su daño."));
        service.guardar(new Heroe("juno", "Juno", "apoyo", "Juno, la primera humana nacida en Marte, usa su tecnología de vanguardia para resolver cualquier problema que entre en su órbita. Está decidida a salvar algún día su planeta natal.", "Imagenes/Juno/portada_juno.png", 225, habJuno));

        // ── Kiriko ──────────────────────────────────────────────────────────
        List<Habilidad> habKiriko = new ArrayList<>();
        habKiriko.add(new Habilidad("pasivaRol",      "Función: Apoyo",        "Imagenes/habilidades_comunes/rol_supp.svg",     "Empieza a regenerar salud más rápidamente."));
        habKiriko.add(new Habilidad("pasivaPropia",   "Escalada",              "Imagenes/Kiriko/escalada_kiriko.png",           "Satas hacia una pared para trepar por ella."));
        habKiriko.add(new Habilidad("arma",           "Ofuda de sanación",     "Imagenes/Kiriko/ofudas.png",                    "Canalizas una ráfaga de talismanes hacia los aliados seleccionados."));
        habKiriko.add(new Habilidad("arma",           "Kunái",                 "Imagenes/Kiriko/kunai.png",                     "Proyectil arrojadizo de largo alcance."));
        habKiriko.add(new Habilidad("habilidad",      "Paso ligero",           "Imagenes/Kiriko/tp.png",                        "Te teletransportas junto a un aliado."));
        habKiriko.add(new Habilidad("habilidad",      "Suzu de protección",    "Imagenes/Kiriko/suzu.png",                      "Lanzas un amuleto protector que vuelve invulnerable a los aliados durante unos instantes y elimina la mayoría de los efectos negativos."));
        habKiriko.add(new Habilidad("definitiva",     "Marcha kitsune",        "Imagenes/Kiriko/kitsune.png",                   "Invocas el espíritu de un zorro que avanza hacia delante y potencia el movimiento, la velocidad de ataque y los tiempos de reutilización de los aliados que sigan el camino."));
        service.guardar(new Heroe("kiriko", "Kiriko", "apoyo", "Como sacerdotisa del santuario Kanezaka e hija del antiguo maestro de la espada de los Shimada, Kiriko Kamori canaliza tanto sus habilidades espirituales como ninja para sanar su ciudad fracturada.", "Imagenes/Kiriko/portada_kiriko.png", 225, habKiriko));

        // ── Lifeweaver ──────────────────────────────────────────────────────────
        List<Habilidad> habLifeweaver = new ArrayList<>();
        habLifeweaver.add(new Habilidad("pasivaRol",      "Función: Apoyo",           "Imagenes/habilidades_comunes/rol_supp.svg",     "Empieza a regenerar salud más rápidamente."));
        habLifeweaver.add(new Habilidad("arma",           "Brote sanador",            "Imagenes/Lifeweaver/healing_blossom.png",       "Mantén pulsado para cargar una sanación y sueltalo para sanar al aliado seleccionado.<br>Se carga pasivamente a una velocidad reducida cuando no se utiliza."));
        habLifeweaver.add(new Habilidad("arma",           "Salva de espinas",         "Imagenes/Lifeweaver/espinas.png",               "Dispara rápidamente proyectiles a pares."));
        habLifeweaver.add(new Habilidad("habilidad",      "Plataforma petaloide",     "Imagenes/Lifeweaver/platform.png",              "Lanza una plataforma que se eleva cuando alguien se sube. Se reinicia cuando no se utiliza."));
        habLifeweaver.add(new Habilidad("habilidad",      "Paso regenerador",         "Imagenes/Lifeweaver/dash.png",                  "Cargas hacia la dirección de desplazamiento y te curas un poco."));
        habLifeweaver.add(new Habilidad("habilidad",      "Agarre vital",             "Imagenes/Lifeweaver/grip.png",                  "Atraes un aliado a tu ubicación y lo proteges durante el recorrido."));
        habLifeweaver.add(new Habilidad("definitiva",     "Árbol de vida",            "Imagenes/Lifeweaver/tree.png",                  "Plantas un árbol qye brota y sana a los aliados al instante. Otorga sanación continua mientas vive."));
        service.guardar(new Heroe("lifeweaver", "Lifeweaver", "apoyo", "El brillante creador de la bioluz, una tecnología que fusiona materia vegetal y luz dura. Sueña con sanar el mundo.", "Imagenes/Lifeweaver/portada_lifeweaver.png", 250, habLifeweaver));

        // ── Lucio ──────────────────────────────────────────────────────────
        List<Habilidad> habLucio = new ArrayList<>();
        habLucio.add(new Habilidad("pasivaRol",      "Función: Apoyo",         "Imagenes/habilidades_comunes/rol_supp.svg",    "Empieza a regenerar salud más rápidamente."));
        habLucio.add(new Habilidad("pasivaPropia",   "Trotamuros",             "Imagenes/Lucio/wall_ride.png",                 "Saltas a una pared para impulsarte por ella."));
        habLucio.add(new Habilidad("arma",           "Amplificador sónico",    "Imagenes/Lucio/arma_lucio.png",                "Lanzador de proyectiles sónicos."));
        habLucio.add(new Habilidad("habilidad",      "Cambio de pista",        "Imagenes/Lucio/crossfade.png",                 "Alternas entre dos canciones. Mejora de sanación sana a los aliados cercanos. Mejora de velocidad hace que los aliados cercanos se muevan más rápidos."));
        habLucio.add(new Habilidad("habilidad",      "Subidón",                "Imagenes/Lucio/amp_it_up.png",                 "Aumenta la eficacia de tu canción actual."));
        habLucio.add(new Habilidad("habilidad",      "Onda sonora",            "Imagenes/Lucio/boop.png",                      "Provocas una explosión de corto alcance que repele a los enemigos."));
        habLucio.add(new Habilidad("definitiva",     "Barrera de sonido",      "Imagenes/Lucio/beat.png",                      "Creas salud adicional temporal para los aliados cercanos."));
        service.guardar(new Heroe("lucio", "Lucio", "apoyo", "Lúcio es una celebridad internacional que inspira el cambio social a través de su música y su activismo.", "Imagenes/Lucio/portada_lucio.png", 225, habLucio));

        // ── Mercy ──────────────────────────────────────────────────────────
        List<Habilidad> habMercy = new ArrayList<>();
        habMercy.add(new Habilidad("pasivaRol",      "Función: Apoyo",          "Imagenes/habilidades_comunes/rol_supp.svg",    "Empieza a regenerar salud más rápidamente."));
        habMercy.add(new Habilidad("pasivaPropia",   "Descenso angélico",       "Imagenes/Mercy/angelic_descent.png",           "Ralentiza tu caída"));
        habMercy.add(new Habilidad("pasivaPropia",   "Recuperación rápida",     "Imagenes/Mercy/recuperacion_rapida.png",       "Empiezas a regenerar salud más rápidamente."));
        habMercy.add(new Habilidad("arma",           "Bastón caduceo",          "Imagenes/Mercy/staff.png",                     "Mantén pulsado el click izquierdo para sanar a un aliado.<br>Mantén pulsado el click derecho para aumentar el daño que inflinges."));
        habMercy.add(new Habilidad("arma",           "Pistola caducea",         "Imagenes/Mercy/blaster.png",                   "Arma automática."));
        habMercy.add(new Habilidad("habilidad",      "Ángel de la guarda",      "Imagenes/Mercy/guardian_angel.png",            "Vuelas hacia un aliado. Durante el vuelo, saltar te lanza hacia delante y agachate te propulsa hacia arriba."));
        habMercy.add(new Habilidad("habilidad",      "Resurección",             "Imagenes/Mercy/res.png",                       "Resucitas a un aliado caído."));
        habMercy.add(new Habilidad("habilidad",      "Sanación instantánea",    "Imagenes/Mercy/healing_burst.png",             "Sana al objetivo activo de Bastón caduceo. La sanación se duplica en aliados con la salud por debajo de la mitad."));
        habMercy.add(new Habilidad("definitiva",     "Valkiria",                "Imagenes/Mercy/valkyrie.png",                  "Te permite volar y potencia tus habilidades."));
        service.guardar(new Heroe("mercy", "Mercy", "apoyo", "La Dra. Angela Ziegler es un ángel guardián para quienes están bajo su cuidado: una sanadora sin igual, una científica brillante y una firme defensora de la paz.", "Imagenes/Mercy/portada_mercy.png", 225, habMercy));

    }

    @GetMapping("/heroes")
    public List<Heroe> getHeroes() {
        return service.listar();
    }

    @GetMapping("/heroes/{id}")
    public Heroe getHeroe(@PathVariable String id) {
        return service.buscarPorId(id);
    }

    @PostMapping("/heroes")
    public Heroe addHeroe(@RequestBody Heroe heroe) {
        return service.guardar(heroe);
    }

}