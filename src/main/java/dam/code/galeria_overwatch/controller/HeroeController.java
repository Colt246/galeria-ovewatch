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


        // ========================================================== Tanques ==========================================================

        // --- D.Va ----------------------------------------------------------
        List<Habilidad> habDva = new ArrayList<>();
        habDva.add(new Habilidad("pasivaRol",     "Función: Tanque",    "Imagenes/habilidades_comunes/rol_tank.svg",  "Reduce los retrocesos y el daño crítico recibido. Reduce la generación de definitiva por curación y daño recibido. Aumenta la salud base en los modos de juego de cola de roles."));
        habDva.add(new Habilidad("pasivaPropia",  "¡Eyección!",         "Imagenes/D.va/eyeccion.png",                 "Eyecta fuera del MECA cuando es destruido."));
        habDva.add(new Habilidad("arma",          "Cañones de fusión",  "Imagenes/D.va/cañon_fusion.png",             "Armas automáticas de corto alcance y dispersión."));
        habDva.add(new Habilidad("arma",          "Pistola de luz",     "Imagenes/D.va/pistola_luz.png",              "Arma automática."));
        habDva.add(new Habilidad("habilidad",     "Matriz de defensa",  "Imagenes/D.va/matrix.png",                   "Bloquea proyectiles en un área frente a ti."));
        habDva.add(new Habilidad("habilidad",     "Impulsores",         "Imagenes/D.va/boosters.png",                 "Vuela en la dirección en que estás mirando."));
        habDva.add(new Habilidad("habilidad",     "Micromisiles",       "Imagenes/D.va/micromisiles.png",             "Lanza una descarga de cohetes explosivos."));
        habDva.add(new Habilidad("definitiva",    "Autodestrucción",    "Imagenes/D.va/dva_bomb.png",                 "Expulsa al piloto y sobrecarga tu MECA, provocando que explote después de un corto periodo de tiempo."));
        habDva.add(new Habilidad("definitiva",    "MECA",               "Imagenes/D.va/call_mech.png",                "Después de que tu MECA haya sido destruido cae de nuevo a un nuevo MECA para subirse de nuevo."));
        service.guardar(new Heroe("dva", "D.Va", "tanque", "D.Va era una jugadora profesional que ahora aprovecha sus habilidades para pilotar un meca de última generación al servicio de su país.", "Imagenes/D.va/portada_dva.png", 650, habDva));

        // --- Domina ----------------------------------------------------------
        List<Habilidad> habDomina= new ArrayList<>();
        habDomina.add(new Habilidad("pasivaRol",    "Función: Tanque",       "Imagenes/habilidades_comunes/rol_tank.svg",   "Reduce los retrocesos y el daño crítico recibido. Reduce la generación de definitiva por curación y daño recibido. Aumenta la salud base en los modos de juego de cola de roles."));
        habDomina.add(new Habilidad("pasivaPropia", "Reconstrucción",        "Imagenes/Domina/pasiva_domina.png",           "Inflingir daño con habilidades restaura escudos."));
        habDomina.add(new Habilidad("arma",         "Cañón de fotones",      "Imagenes/Domina/photon_magnum.png",           "Haz de alcance medio que culmina con un disparo de alto impacto."));
        habDomina.add(new Habilidad("habilidad",    "Matriz barrera",        "Imagenes/Domina/barrier_array.png",           "Construye una barrera segmentada."));
        habDomina.add(new Habilidad("habilidad",    "Repulsores sónicos",    "Imagenes/Domina/sonic_pulsor.png",            "Empuja hacia atrás a los enemigos, aturdiéndolos si golpean una pared."));
        habDomina.add(new Habilidad("habilidad",    "Carga de cristal",      "Imagenes/Domina/crystal.png",                 "Proyecta un cristal explosivo y lo reactiva para detonarlo."));
        habDomina.add(new Habilidad("definitiva",   "Panóptico",             "Imagenes/Domina/panopticon.png",              "Dispara una barrera de luz sólida que aprisiona a los jugadores y detona al acabar."));
        service.guardar(new Heroe("domina", "Domina", "tanque", "Como la negociadora más valiosa de la corporación Vishkar, Domina usa su gran dominio de la luz sólida para hacerse con el control de cualquier situación.", "Imagenes/Domina/portada_domina.png", 650, habDomina));

        // --- Doomfist ----------------------------------------------------------
        List<Habilidad> habDoom = new ArrayList<>();
        habDoom.add(new Habilidad("pasivaRol",    "Función: Tanque",     "Imagenes/habilidades_comunes/rol_tank.svg", "Reduce los retrocesos y el daño crítico recibido. Reduce la generación de definitiva por curación y daño recibido. Aumenta la salud base en los modos de juego de cola de roles."));
        habDoom.add(new Habilidad("pasivaPropia", "La mejor defensa...", "Imagenes/Doomfist/pasiva_doom.png",         "Inflingir daño con habilidades crea un exceso de salud temporal."));
        habDoom.add(new Habilidad("arma",         "Cañón de mano",       "Imagenes/Doomfist/cañon_mano.png",          "Arma de corto alcance con dispersión. Se recarga automáticamente."));
        habDoom.add(new Habilidad("habilidad",    "Puño cohete",         "Imagenes/Doomfist/punch.png",               "Mantén pulsado para cargar y suelta para lanzarte hacia delante y derribar al enemigo. El daño aumenta si el enemigo choca contra una pared."));
        habDoom.add(new Habilidad("habilidad",    "Golpe sísmico",       "Imagenes/Doomfist/slam_doom.png",           "Salta hacia delante y golpea el suelo."));
        habDoom.add(new Habilidad("habilidad",    "Bloqueo de poder",    "Imagenes/Doomfist/block_doom.png",          "Protégete de los ataques frontales. Bloquear daño fuerte potencia la habilidad Puño Cohete."));
        habDoom.add(new Habilidad("definitiva",   "Meteoro",             "Imagenes/Doomfist/meteor.png",              "Al pulsar la tecla de la definitiva el personaje salta y desapace. Mueve el área circular donde volverá a caer golpeando la zona objetivo. Se sana durante el tiempo que esté en el aire sin golpear el suelo."));
        service.guardar(new Heroe("doomfist", "Doomfist", "tanque", "Doomfist fue el líder calculador de Talon, una organización terrorista y fuerza paramilitar que actúa en oposición directa a Overwatch.", "Imagenes/Doomfist/portada_doom.png", 525, habDoom));

        // --- Hazard ----------------------------------------------------------
        List<Habilidad> habHazard = new ArrayList<>();
        habHazard.add(new Habilidad("pasivaRol",    "Función: Tanque",     "Imagenes/habilidades_comunes/rol_tank.svg", "Reduce los retrocesos y el daño crítico recibido. Reduce la generación de definitiva por curación y daño recibido. Aumenta la salud base en los modos de juego de cola de roles."));
        habHazard.add(new Habilidad("pasivaPropia", "Brinco",              "Imagenes/Hazard/brinco.png",                "Escala paredes cortas y se agarra a cornisas."));
        habHazard.add(new Habilidad("arma",         "Lanzaespinas",        "Imagenes/Hazard/arma_hazard.png",           "Dispara una ráfaga de púas."));
        habHazard.add(new Habilidad("habilidad",    "Protección de púas",  "Imagenes/Hazard/proteccion_puas.png",       "Protégete del daño frontal. Dispara púas teledirigidas a los enemigos cercanos y regenera munición."));
        habHazard.add(new Habilidad("habilidad",    "Salto violento",      "Imagenes/Hazard/salto_violento.png",        "Arremete hacia adelante. Actívalo de nuevo para cortar a los enemigos y empujarlos hacia atrás."));
        habHazard.add(new Habilidad("habilidad",    "Muro afilado",        "Imagenes/Hazard/muro_hazard.png",           "Lanza un muro con púas que daña y derriba a los enemigos cercanos."));
        habHazard.add(new Habilidad("definitiva",   "Aguacero",            "Imagenes/Hazard/hazard_ult.png",            "Hace llover un torrente de púas que inmovilizan a los enemigos."));
        service.guardar(new Heroe("hazard", "Hazard", "tanque", "Hazard, perturbador radical y arma imparable, se ha hecho famoso en el submundo criminal por luchar para acabar con el sistema.", "Imagenes/Hazard/portada_hazard.png", 650, habHazard));

        // --- Junker Queen ----------------------------------------------------------
        List<Habilidad> habQueen = new ArrayList<>();
        habQueen.add(new Habilidad("pasivaRol",    "Función: Tanque",              "Imagenes/habilidades_comunes/rol_tank.svg",  "Reduce los retrocesos y el daño crítico recibido. Reduce la generación de definitiva por curación y daño recibido. Aumenta la salud base en los modos de juego de cola de roles."));
        habQueen.add(new Habilidad("pasivaPropia", "Subidón de adrenalina",        "Imagenes/Junker_Queen/pasiva_queen.png",     "Secura todo el daño a lo largo del tiempo unflingido por las heridas."));
        habQueen.add(new Habilidad("arma",         "Escopeta",                     "Imagenes/Junker_Queen/escopeta_queen.png",   "Escopeta de corredera."));
        habQueen.add(new Habilidad("habilidad",    "Cuchilla dentada (Gracie)",    "Imagenes/Junker_Queen/gracie.png",           "Activa: lanzas la cuchilla. Puedes reactivarla para recuperarla y atraer al enemigo empalado.<br>Pasiva: los ataques cuerpo a cuerpo o lanzamientos hieren a los enemigos e inflingen daño en el tiempo."));
        habQueen.add(new Habilidad("habilidad",    "Grito de mando",               "Imagenes/Junker_Queen/grito_mando.png",      "Otorga salud temporal y velocidad de movimiento a ti y a tus aliados."));
        habQueen.add(new Habilidad("habilidad",    "Matanza",                      "Imagenes/Junker_Queen/hacha.png",            "Hiere a todos los enemigos frente a ti, lo que inflige daño a lo largo del tiempo y reduce el tiempo de recuperación de cada enemigo golpeado."));
        habQueen.add(new Habilidad("definitiva",   "Masacre",                      "Imagenes/Junker_Queen/rampage.png",          "Carga hacia adelante. Hiere a los enemigos, infligiendo daño prolongado e impidiendo su curación."));
        service.guardar(new Heroe("junkerQueen", "Junker Queen", "tanque", "Provista de su hacha Matanza y un guante electromagnético, la feroz líder de los Chatarreros emprende una misión para dominar el mundo.", "Imagenes/Junker_Queen/portada_queen.png", 525, habQueen));

        // --- Mauga ----------------------------------------------------------
        List<Habilidad> habMauga = new ArrayList<>();
        habMauga.add(new Habilidad("pasivaRol",    "Función: Tanque",                      "Imagenes/habilidades_comunes/rol_tank.svg",  "Reduce los retrocesos y el daño crítico recibido. Reduce la generación de definitiva por curación y daño recibido. Aumenta la salud base en los modos de juego de cola de roles."));
        habMauga.add(new Habilidad("pasivaPropia", "Berserker",                            "Imagenes/Mauga/pasiva_mauga.png",            "Obtienes salud temporal al inflingir daño crítico."));
        habMauga.add(new Habilidad("arma",         "Cañón de cadena incendiario (Lleta)",  "Imagenes/Mauga/arma_mauga_fuego.png",        "Arma automática que enciende a los enemigos con impactos repetidos."));
        habMauga.add(new Habilidad("arma",         "Cañón de cadena volátil (Metra)",      "Imagenes/Mauga/arma_mauga_critico.png",      "Arma automática que inflige daño crítico a los enemigos en llamas."));
        habMauga.add(new Habilidad("habilidad",    "Arrollar",                             "Imagenes/Mauga/arrollar_mauga.png",          "Embistes y das un pisotón para lanzar a los enemigos por los aires. Eres imparable mientras embites."));
        habMauga.add(new Habilidad("habilidad",    "Sobreestimulación cardíaca",           "Imagenes/Mauga/cardiac.png",                 "Otorga reducción de daño y los aliados cercanos se sanan al inflingir daño."));
        habMauga.add(new Habilidad("definitiva",   "Mano a mano",                          "Imagenes/Mauga/cage.png",                    "Despliegas una barrera que os encierra a ti y a los enemigos."));
        service.guardar(new Heroe("mauga", "Mauga", "tanque", "Mauga, guerrero samoano carismático y astuto como pocos, se abre paso entre el caos del campo de batalla y vive cada día como si fuera el último.", "Imagenes/Mauga/portada_mauga.png", 725, habMauga));

        // --- Orisa ----------------------------------------------------------
        List<Habilidad> habOrisa = new ArrayList<>();
        habOrisa.add(new Habilidad("pasivaRol",      "Función: Tanque",                     "Imagenes/habilidades_comunes/rol_tank.svg",    "Reduce los retrocesos y el daño crítico recibido. Reduce la generación de definitiva por curación y daño recibido. Aumenta la salud base en los modos de juego de cola de roles."));
        habOrisa.add(new Habilidad("arma",           "Ametralladora de fusión aumentada",   "Imagenes/Orisa/arma_orisa.png",                "Arma térmica automática."));
        habOrisa.add(new Habilidad("habilidad",      "Jabalina de energía",                 "Imagenes/Orisa/javelin.png",                   "Lanzas la jabalina a un enemigo para aturdirlo y repelerlo. La efectividad aumenta si el enemigo choca contra una pared."));
        habOrisa.add(new Habilidad("habilidad",      "Fortificación",                       "Imagenes/Orisa/fortify.png",                   "Obtienes salud de duración limitada, reduces todo el daño recibido y te vuelves imparable."));
        habOrisa.add(new Habilidad("habilidad",      "Girojabalina",                        "Imagenes/Orisa/spin.png",                      "Giras la jabalina para destruir proyectiles y bloquear ataques cuerpo a cuerpo, y también para empujar a los enemigos y aumentar la velocidad de movimiento hacia delante."));
        habOrisa.add(new Habilidad("definitiva",     "Terraavulsión",                       "Imagenes/Orisa/terra.png",                     "Atraes a los enemigos, te quedas quieta y obtienes los efectos de Fortificación mientras cargas un aluvión de daño. Usa el click izquierdo para liberarlo antes de tiempo."));
        service.guardar(new Heroe("orisa", "Orisa", "tanque", "Orisa, construida a partir de los restos de uno de los robots OR-15 que durante un breve tiempo ejercieron como defensores de Numbani, es la más reciente protectora de la ciudad, aunque todavía tiene mucho que aprender.", "Imagenes/Orisa/portada_orisa.png", 600, habOrisa));

        // --- Ramattra ----------------------------------------------------------
        List<Habilidad> habRam = new ArrayList<>();
        habRam.add(new Habilidad("pasivaRol",    "Función: Tanque",                         "Imagenes/habilidades_comunes/rol_tank.svg",     "Reduce los retrocesos y el dañocrítico recibido. Reduce la generación de definitiva por curación y daño recibido. Aumenta la salud base en los modos de juego de cola de roles."));
        habRam.add(new Habilidad("arma",         "Acelerador de vacío (Forma de Ómnico)",   "Imagenes/Ramattra/arma_ram.png",                "Lanza una andanada de proyectiles."));
        habRam.add(new Habilidad("arma",         "Aporrear (Forma de Némesis)",             "Imagenes/Ramattra/punch.png",                   "Lanzas un puñetazo, lo que genera una oleada de energía perforadora con cada golpe."));
        habRam.add(new Habilidad("habilidad",    "Barrera de vacío (Forma de Ómnico)",      "Imagenes/Ramattra/barrier.png",                 "Crea una barrera en la ubicación seleccionada."));
        habRam.add(new Habilidad("habilidad",    "Forma de Némesis",                        "Imagenes/Ramattra/nemesis.png",                 "Adoptas la Forma de Némesis, lo que cambia tus ataques y te otorga una bonificación de armadura."));
        habRam.add(new Habilidad("habilidad",    "Bloquear (Forma de Némesis)",             "Imagenes/Ramattra/bloqueo.png",                 "Reduce en gran medida el daño recibido de frente y reduce la velocidad de movimiento."));
        habRam.add(new Habilidad("habilidad",    "Vórtice voraz",                           "Imagenes/Ramattra/vortex.png",                  "Lanzas una esfera de energía que detona en el suelo que ralentiza y derriba a los enemigos. Actívalo de nuevo para detonarla antes."));
        habRam.add(new Habilidad("definitiva",   "Aniquilación",                            "Imagenes/Ramattra/annihilation.png",            "Adoptas la forma de némesis y creas un enjambre letal que se abalanza sobre los enemigos cercanos y que dura más cuando inflinge daño a los enemigos."));
        service.guardar(new Heroe("ramattra", "Ramattra", "tanque", "Nada impedirá que el brutal líder de Null Sector haga realidad su visión del mundo.", "Imagenes/Ramattra/portada_ram.png", 525, habRam));

        // --- Reinhardt ----------------------------------------------------------
        List<Habilidad> habRein = new ArrayList<>();
        habRein.add(new Habilidad("pasivaRol",      "Función: Tanque",      "Imagenes/habilidades_comunes/rol_tank.svg", "Reduce los retrocesos y el daño crítico recibido. Reduce la generación de definitiva por curación y daño recibido. Aumenta la salud base en los modos de juego de cola de roles."));
        habRein.add(new Habilidad("arma",           "Martillo a reacción",  "Imagenes/Reinhardt/hammer.png",             "Arma cuerpo a cuerpo devastadora."));
        habRein.add(new Habilidad("habilidad",      "Embestida",            "Imagenes/Reinhardt/charge.png",             "Cargas hacia delante y empotras a un enemigo contra la pared."));
        habRein.add(new Habilidad("habilidad",      "Onda de fuego",        "Imagenes/Reinhardt/fire_strike.png",        "Lanzas un proyectil de fuego."));
        habRein.add(new Habilidad("habilidad",      "Campo protector",      "Imagenes/Reinhardt/barrier.png",            "Mantén pulsado para activar una barrera de energía frontal."));
        habRein.add(new Habilidad("definitiva",     "Seísmo",               "Imagenes/Reinhardt/shatter.png",            "Derribas a todos los enemigos frente a ti."));
        service.guardar(new Heroe("reinhardt", "Reinhardt", "tanque", "Reinhardt Wilhelm es un campeón de una era pasada que vive según los antiguos ideales de la caballería: honor, justicia y valor.", "Imagenes/Reinhardt/portada_rein.png", 700, habRein));

        // --- Roadhog ----------------------------------------------------------
        List<Habilidad> habHog = new ArrayList<>();
        habHog.add(new Habilidad("pasivaRol",      "Función: Tanque",      "Imagenes/habilidades_comunes/rol_tank.svg",    "Reduce los retrocesos y el daño crítico recibido. Reduce la generación de definitiva por curación y daño recibido. Aumenta la salud base en los modos de juego de cola de roles."));
        habHog.add(new Habilidad("arma",           "Chatarrera",           "Imagenes/Roadhog/scrap_gun.png",               "Arma de disparo esparcido de corto alcance."));
        habHog.add(new Habilidad("arma",           "Disparo secundario",   "Imagenes/Roadhog/disparo_secundario.png",      "Proyectil de alcance medio/alto que explota y se divide en el disparo principal de corto alcance del arma."));
        habHog.add(new Habilidad("habilidad",      "Garfio",               "Imagenes/Roadhog/hook.png",                    "Arrastras a un enemigo hacia ti."));
        habHog.add(new Habilidad("habilidad",      "Inhalador",            "Imagenes/Roadhog/breather.png",                "Te curas y reduces el daño que recibes."));
        habHog.add(new Habilidad("definitiva",     "Juego sucio",          "Imagenes/Roadhog/whole_hog.png",               "Dañas y repeles a todos los enemigos frente a ti."));
        service.guardar(new Heroe("roadhog", "Roadhog", "tanque", "Roadhog es un sicario implacable que se ha labrado una reputación de criminal arbitrario aficionado a la destrucción.", "Imagenes/Roadhog/portada_hog.png", 750, habHog));

        // --- Sigma ----------------------------------------------------------
        List<Habilidad> habSigma = new ArrayList<>();
        habSigma.add(new Habilidad("pasivaRol",      "Función: Tanque",      "Imagenes/habilidades_comunes/rol_tank.svg",   "Reduce los retrocesos y el daño crítico recibido. Reduce la generación de definitiva por curación y daño recibido. Aumenta la salud base en los modos de juego de cola de roles."));
        habSigma.add(new Habilidad("arma",           "Hiperesferas",         "Imagenes/Sigma/hyperspheres.png",             "Lanzas dos cargas que implosionan tras un corto periodo de tiempo, lo que infligen daño en un área."));
        habSigma.add(new Habilidad("habilidad",      "Agarre cinético",      "Imagenes/Sigma/kinetic_grasp.png",            "Absorbes proyectiles frente a ti y los conviertes en salud adicional."));
        habSigma.add(new Habilidad("habilidad",      "Acreción",             "Imagenes/Sigma/rock.png",                     "Reúnes una masa de escombros, la lanzas contra un enemigo y lo derribas."));
        habSigma.add(new Habilidad("habilidad",      "Barrera experimental", "Imagenes/Sigma/barrier.png",                  "Mantén pulsado para proyectar una barrera flotante; suéltalo para pararla. Pulsa de nuevo para hacer que la barrera vuelva a ti."));
        habSigma.add(new Habilidad("definitiva",     "Flujo gravitacional",  "Imagenes/Sigma/flux.png",                     "Manipula la gravedad para alzar a los enemigos en el aire y luego estrellarlos contra el suelo."));
        service.guardar(new Heroe("sigma", "Sigma", "tanque", "La vida del brillante astrofísico Siebren de Kuiper cambió para siempre cuando un experimento fallido le otorgó la capacidad de controlar la gravedad. Ahora Talon lo manipula para sus propios fines.", "Imagenes/Sigma/portada_sigma.png", 625, habSigma));

        // --- Winston ----------------------------------------------------------
        List<Habilidad> habWinston = new ArrayList<>();
        habWinston.add(new Habilidad("pasivaRol",    "Función: Tanque",      "Imagenes/habilidades_comunes/rol_tank.svg",    "Reduce los retrocesos y el dañocrítico recibido. Reduce la generación de definitiva por curación y daño recibido. Aumenta la salud base en los modos de juego de cola de roles."));
        habWinston.add(new Habilidad("arma",         "Cañón Tesla",          "Imagenes/Winston/tesla.png",                   "Arma que dispara electricidad en un cono frontal."));
        habWinston.add(new Habilidad("arma",         "Disparo secundario",   "Imagenes/Winston/disparo_secundario.png",      "Mantén pulsado para cargar y suéltalo para disparar electricidad concentrada."));
        habWinston.add(new Habilidad("habilidad",    "Salto potenciado",     "Imagenes/Winston/jump.png",                    "Saltas por el aire. Si aterrizas sobre un enemigo, le infliges daño."));
        habWinston.add(new Habilidad("habilidad",    "Campo de fuerza",      "Imagenes/Winston/bubble.png",                  "Despliegas una cúpula de energía protectora."));
        habWinston.add(new Habilidad("definitiva",   "Rabia primigenia",     "Imagenes/Winston/primal.png",                  "Obtienes gran cantidad de salud, pero solo puedes saltar y dar puñetazos."));
        service.guardar(new Heroe("winston", "Winston", "tanque", "Winston, un gorila superinteligente modificado genéticamente, también es un científico brillante y un defensor del potencial de la humanidad.", "Imagenes/Winston/portada_winston.png", 625, habWinston));

        // --- Wrecking Ball ----------------------------------------------------------
        List<Habilidad> habBall = new ArrayList<>();
        habBall.add(new Habilidad("pasivaRol",    "Función: Tanque",      "Imagenes/habilidades_comunes/rol_tank.svg",    "Reduce los retrocesos y el dañocrítico recibido. Reduce la generación de definitiva por curación y daño recibido. Aumenta la salud base en los modos de juego de cola de roles."));
        habBall.add(new Habilidad("arma",         "Cañones cuádruples",   "Imagenes/Wrecking_Ball/arma_ball.png",         "Armas de asalto automáticas."));
        habBall.add(new Habilidad("habilidad",    "Gancho garra",         "Imagenes/Wrecking_Ball/claw.png",              "Lanzas un gancho que te permite desplazarte rápidamente por la zona. También hace que dañes a un enemigo y que lo repelas cuando chocas contra él a gran velocidad."));
        habBall.add(new Habilidad("habilidad",    "Bola arrolladora",     "Imagenes/Wrecking_Ball/roll.png",              "Te transformas en una bola, lo que aumenta tu velocidad de movimiento máxima."));
        habBall.add(new Habilidad("habilidad",    "Impacto demoledor",    "Imagenes/Wrecking_Ball/slam.png",              "Te lanzas al suelo en picado, infliges daño a los enemigos y los haces saltar por los aires."));
        habBall.add(new Habilidad("habilidad",    "Escudo adaptable",     "Imagenes/Wrecking_Ball/shield.png",            "Crea salud adicional de duración limitada que aumenta cuantos más enemigos tengas cerca. Puedes transferir parte de esa salud a tus aliados."));
        habBall.add(new Habilidad("definitiva",   "Campo de minas",       "Imagenes/Wrecking_Ball/minefield.png",         "Despliegas un gran campo de minas de proximidad."));
        service.guardar(new Heroe("wreckingBall", "Wrecking Ball", "tanque", "Wrecking Ball, mecánico inteligentísimo y habilidoso, además de luchador, surgió de los laboratorios de Colonia Lunar Horizon para convertirse en el campeón de Junker Queen.", "Imagenes/Wrecking_Ball/portada_ball.png", 725, habBall));

        // --- Zarya ----------------------------------------------------------
        List<Habilidad> habZarya = new ArrayList<>();
        habZarya.add(new Habilidad("pasivaRol",    "Función: Tanque",          "Imagenes/habilidades_comunes/rol_tank.svg",   "Reduce los retrocesos y el dañocrítico recibido. Reduce la generación de definitiva por curación y daño recibido. Aumenta la salud base en los modos de juego de cola de roles."));
        habZarya.add(new Habilidad("pasivaPropia", "Energía",                  "Imagenes/Zarya/energy.png",                   "El daño que bloquean las barreras aumenta el daño del cañón de partículas."));
        habZarya.add(new Habilidad("arma",         "Cañón de partículas",      "Imagenes/Zarya/particle_cannon.png",          "Arma que dispara un haz lineal de corto alcance."));
        habZarya.add(new Habilidad("arma",         "Disparo secundario",       "Imagenes/Zarya/disparo_secundario.png",       "Lanzas granadas de energía."));
        habZarya.add(new Habilidad("habilidad",    "Barrera de partículas",    "Imagenes/Zarya/personal_bubble.png",          "Crea una barrera de daño a tu alrededor."));
        habZarya.add(new Habilidad("habilidad",    "Barrera proyectada",       "Imagenes/Zarya/ally_bubble.png",              "Crea una barrera de daño alrededor de un aliado."));
        habZarya.add(new Habilidad("definitiva",   "Bomba de gravedad",        "Imagenes/Zarya/grav.png",                     "Lanza un pozo de gravedad que atrae a los enemigos."));
        service.guardar(new Heroe("zarya", "Zarya", "tanque", "Aleksandra Zaryanova es una de las mujeres más fuertes del mundo: una atleta que sacrificó la gloria personal para proteger a su familia, sus amigos y su país en tiempos de guerra.", "Imagenes/Zarya/portada_zarya.png", 550, habZarya));


        // ========================================================== DPS ==========================================================

        // --- Anran ----------------------------------------------------------
        List<Habilidad> habAnran = new ArrayList<>();
        habAnran.add(new Habilidad("pasivaRol",    "Función: Daño",          "Imagenes/habilidades_comunes/rol_dps.svg",     "Dañar a un enemigo reduce temporalmente la curación que recibe."));
        habAnran.add(new Habilidad("pasivaPropia", "Ignición",               "Imagenes/Anran/ignicion.png",                  "Golpea a los enemigos con ataques de fuego para quemarlos."));
        habAnran.add(new Habilidad("arma",         "Abanicos Zhuque",        "Imagenes/Anran/abanicos.png",                  "Abanicos que disparan proyectiles ardientes."));
        habAnran.add(new Habilidad("arma",         "Atizar el fuego",        "Imagenes/Anran/avivar.png",                    "Una explosión de aire caliente que aumenta el daño por quemadura."));
        habAnran.add(new Habilidad("habilidad",    "Carga infernal",         "Imagenes/Anran/carga_infernal.png",            "Te impulsa hacia delante y daña a los enemigos."));
        habAnran.add(new Habilidad("habilidad",    "Llama danzante",         "Imagenes/Anran/llama.png",                     "Golpea a los enemigos cercanos mientas esquivas y te sanas por cada enemigo golpeado."));
        habAnran.add(new Habilidad("definitiva",   "Ascenso bermellón",      "Imagenes/Anran/ascenso_bermellon.png",         "Cargas hacia delante, explota al impactar y prende a los enemigos inmediatamente."));
        habAnran.add(new Habilidad("definitiva",   "Renacimiento bermellón", "Imagenes/Anran/renacimiento.png",              "Cuando mueres, te revive con una explosión abrasadora."));
        service.guardar(new Heroe("anran", "Anran", "dps", "La estrella graduada de la Facultad del Fuego en la Universidad de Wuxing, Anran, siempre arde en deseos de llevar sus límites más allá de lo imaginable.", "Imagenes/Anran/portada_anran.png", 250, habAnran));

        // --- Ashe ----------------------------------------------------------
        List<Habilidad> habAshe = new ArrayList<>();
        habAshe.add(new Habilidad("pasivaRol",  "Función: Daño", "Imagenes/habilidades_comunes/rol_dps.svg",       "Dañar a un enemigo reduce temporalmente la curación que recibe."));
        habAshe.add(new Habilidad("arma",       "Víbora",        "Imagenes/Ashe/vibora.png",                       "Rifle semiautomátco."));
        habAshe.add(new Habilidad("arma",       "Encañonar",     "Imagenes/habilidades_comunes/apuntado_ashe.png", "Mantén pulsado para acercar el zoom, lo que aumenta el daño y la precisión, pero reduce la cadencia de fuego."));
        habAshe.add(new Habilidad("habilidad",  "Recortada",     "Imagenes/Ashe/coach.png",                        "Acribillas a los enemigos enfrente de ti y te implusa hacia atrás."));
        habAshe.add(new Habilidad("habilidad",  "Dinamita",      "Imagenes/Ashe/dinamita.png",                     "Lanzas un explosivo que detona trás un breve periodo o al instante si le disparas."));
        habAshe.add(new Habilidad("definitiva", "BOB",           "Imagenes/Ashe/bob.png",                          "Despliegas un Bob, que carga hacia delante y lanza a los enemigos por los aires. Luego ataca con los cañones de su brazo."));
        service.guardar(new Heroe("ashe", "Ashe", "dps", "Ashe es la ambiciosa y calculadora líder de la banda Deadlock Rebels y una figura respetada en el mundo criminal de los bajos fondos.", "Imagenes/Ashe/portada_ashe.png", 250, habAshe));

        // --- Bastión ----------------------------------------------------------
        List<Habilidad> habBastion = new ArrayList<>();
        habBastion.add(new Habilidad("pasivaRol",     "Función: Daño",          "Imagenes/habilidades_comunes/rol_dps.svg",    "Dañar a un enemigo reduce temporalmente la curación que recibe."));
        habBastion.add(new Habilidad("pasivaPropia",  "Acorazado",              "Imagenes/Bastion/pasiva_bastion.png",         "Reduce el daño recibido mientras está transformado."));
        habBastion.add(new Habilidad("arma",          "Modo: Reconocimiento",   "Imagenes/Bastion/arma_bastion.png",           "Móvil, con un arma ligera y de gran precisión."));
        habBastion.add(new Habilidad("arma",          "Modo: Asalto",           "Imagenes/Bastion/modo_asalto_bastion.png",    "Un tanque de movimiento lento con un poderoso cañón giratorio."));
        habBastion.add(new Habilidad("habilidad",     "Granada táctica A-36",   "Imagenes/Bastion/granada_bastion.png",        "Dispara una bomba que rebota en las paredes y explota cuando golpea a los enemigos o al suelo."));
        habBastion.add(new Habilidad("habilidad",     "Reconfiguración",        "Imagenes/Bastion/reconfiguracion.png",        "Cambiar entre configuraciones de armas."));
        habBastion.add(new Habilidad("definitiva",    "Modo: Artillería",       "Imagenes/Bastion/bastion_ult.png",            "Queda inmóvil y dispara hasta tres potentes proyectiles de artillería."));
        service.guardar(new Heroe("bastion", "Bastión", "dps", "Antaño un combatiente de primera línea durante la devastadora Crisis Ómnica, ahora esta curiosa unidad Bastion se dedica a explorar el mundo. Le fascina la naturaleza, pero mantiene las distancias con una humanidad que aún recela de los robots.", "Imagenes/Bastion/portada_bastion.png", 350, habBastion));

        // --- Cassidy ----------------------------------------------------------
        List<Habilidad> habCassidy = new ArrayList<>();
        habCassidy.add(new Habilidad("pasivaRol",    "Función: Daño",                       "Imagenes/habilidades_comunes/rol_dps.svg",   "Dañar a un enemigo reduce temporalmente la curación que recibe."));
        habCassidy.add(new Habilidad("arma",         "Pacificador",                         "Imagenes/Cassidy/arma_cass.png",             "Revólver preciso y potente."));
        habCassidy.add(new Habilidad("arma",         "Vaciar cargador",   "Imagenes/Cassidy/alt_shot_cass.png",         "Dispara salvajemente las rondas restantes."));
        habCassidy.add(new Habilidad("habilidad",    "Evasión",                             "Imagenes/Cassidy/combat_roll.png",           "Rueda en la dirección en la que te mueves para recibir menos daño y recargar."));
        habCassidy.add(new Habilidad("habilidad",    "Granada cegadora",                  "Imagenes/Cassidy/flash_bang.png",            "Obstaculiza a los enemigos que están frente a ti, ralentizándolos y evitando que usen habilidades de movimiento."));
        habCassidy.add(new Habilidad("definitiva",   "Sin perdón",                          "Imagenes/Cassidy/high_noon.png",             "Enfréntate a tus enemigos. Pulsa para fijar el objetivo y luego para disparar."));
        service.guardar(new Heroe("cassidy", "Cassidy", "dps", "Armado con su revólver Pacificador, el forajido Cole Cassidy imparte justicia a su manera.", "Imagenes/Cassidy/portada_cass.png", 250, habCassidy));

        // --- Echo ----------------------------------------------------------
        List<Habilidad> habEcho = new ArrayList<>();
        habEcho.add(new Habilidad("pasivaRol",      "Función: Daño",    "Imagenes/habilidades_comunes/rol_dps.svg",   "Dañar a un enemigo reduce temporalmente la curación que recibe."));
        habEcho.add(new Habilidad("pasivaPropia",   "Planeo",           "Imagenes/Echo/echo_glide.png",               "Mantén pulsado el botón de salto mientras caes para planear."));
        habEcho.add(new Habilidad("arma",           "Disparo triple",   "Imagenes/Echo/tri_shot.png",                 "Lanza 3 disparos a la vez en un patrón triangular."));
        habEcho.add(new Habilidad("habilidad",      "Bombas lapa",      "Imagenes/Echo/sticky_bombs.png",             "Lanza una salva de bombas lapa que explotan tras unos instantes."));
        habEcho.add(new Habilidad("habilidad",      "Vuelo",            "Imagenes/Echo/echo_flight.png",              "Vuela rápidamente hacia delante y luego planea con libertad durante unos instantes."));
        habEcho.add(new Habilidad("habilidad",      "Haz enfocado",     "Imagenes/Echo/echo_beam.png",                "Canaliza un haz durante unos segundos. Inflinge un gran daño a los objetivos con menos de la mitad de salud."));
        habEcho.add(new Habilidad("definitiva",     "Duplicado",        "Imagenes/Echo/copy.png",                     "Te combiertes en una copia del héroe enemigo seleccionado, que no puede camabiar el héroe mientras dure el efecto."));
        service.guardar(new Heroe("echo", "Echo", "dps", "Echo es una robot polivalente y adaptable con la inteligencia artificial más sofisticada del mundo. El diseño fue obra de la doctora Mina Liao para las misiones de combate de Overwatch.", "Imagenes/Echo/portada_echo.png", 225, habEcho));

        // --- Emre ----------------------------------------------------------
        List<Habilidad> habEmre = new ArrayList<>();
        habEmre.add(new Habilidad("pasivaRol",   "Función: Daño",              "Imagenes/habilidades_comunes/rol_dps.svg",       "Dañar a un enemigo reduce temporalmente la curación que recibe."));
        habEmre.add(new Habilidad("pasivaPropia","Vitales alterados",          "Imagenes/Emre/vitals.png",                       "La regeneración pasiva de salud se activa antes y restaura inmediatamente 30 puntos de salud cuando se activa."));
        habEmre.add(new Habilidad("arma",        "Rifle de rafaga sintética",  "Imagenes/Emre/burst_rifle.png",                  "Un arma que dispara ráfagas de tres."));
        habEmre.add(new Habilidad("arma",        "Apuntado",                   "Imagenes/habilidades_comunes/apuntado_emre.png",    "Mantén pulsado para acercar el zoom, lo que aumenta la precisión y el alcance de caída."));
        habEmre.add(new Habilidad("habilidad",   "Pistola sifonadora",         "Imagenes/Emre/siphon_pistol.png",                "Empuña temporalmente una pistola semiautomática con balas explosivas que roban vida. Muévete más rápido y salta más alto mientras la empuñas."));
        habEmre.add(new Habilidad("habilidad",   "Granada cibernética",        "Imagenes/Emre/frag.png",                         "Lanza una granada que detona tras rebotar brevemente."));
        habEmre.add(new Habilidad("definitiva",  "Protocolo de anulación",     "Imagenes/Emre/override_protocol.png",                         "Se inicia una anulación, transformándote en un arma viva."));
        service.guardar(new Heroe("emre", "Emre", "dps", "Emre desapareció tras una etapa gloriosa en el equipo de asalto de Overwatch. Años después ha regresado, con el cuerpo y el alma manipulados por algo o alguien desconocido.", "Imagenes/Emre/portada_emre.png", 250, habEmre));

        // --- Freja ----------------------------------------------------------
        List<Habilidad> habFreja = new ArrayList<>();
        habFreja.add(new Habilidad("pasivaRol",      "Función: Daño",               "Imagenes/habilidades_comunes/rol_dps.svg",  "Dañar a un enemigo reduce temporalmente la curación que recibe."));
        habFreja.add(new Habilidad("pasivaPropia",   "Cazadora de recompensas",     "Imagenes/Freja/pasiva_freja.png",           "Cada 3 golpes finales, obtienes carga definitiva adicional."));
        habFreja.add(new Habilidad("arma",           "Ballesta rapaz",              "Imagenes/Freja/ballesta.png",               "Dispara rápidamente cerrojos automáticos."));
        habFreja.add(new Habilidad("arma",           "Apuntado",                    "Imagenes/Freja/apuntado_freja.png",         "Reduce tu velocidad para apuntar con un rayo explosivo de alta velocidad. Usar Carrera Rápida actualiza Apuntar."));
        habFreja.add(new Habilidad("habilidad",      "Desplazamiento veloz",        "Imagenes/Freja/freja_dash.png",             "Salta en la dirección en la que te mueves y actualiza Apuntar."));
        habFreja.add(new Habilidad("habilidad",      "Corriente ascendente",        "Imagenes/Freja/corriente_ascendente.png",   "Despegue hacia arriba con una ráfaga de viento."));
        habFreja.add(new Habilidad("definitiva",     "Disparo de boleadora",        "Imagenes/Freja/bola_shot.png",              "Dispara una bola explosiva. Al impactar a un enemigo, lo envuelve y atrae a otros enemigos cercanos."));
        service.guardar(new Heroe("freja", "Freja", "dps", "Una antigua rescatista convertida en cazarrecompensas, Freja puede encontrar a cualquiera por el precio adecuado.", "Imagenes/Freja/portada_freja.png", 225, habFreja));

        // --- Genji ----------------------------------------------------------
        List<Habilidad> habGenji = new ArrayList<>();
        habGenji.add(new Habilidad("pasivaRol",      "Función: Daño",                 "Imagenes/habilidades_comunes/rol_dps.svg",  "Dañar a un enemigo reduce temporalmente la curación que recibe."));
        habGenji.add(new Habilidad("pasivaPropia",   "Ciberagilidad",                 "Imagenes/Genji/pasiva_genji.png",           "Escala paredes y tiene doble salto."));
        habGenji.add(new Habilidad("arma",           "Shuriken",                      "Imagenes/Genji/shuriken.png",               "Lanza una ráfaga precisa de 3 proyectiles."));
        habGenji.add(new Habilidad("arma",           "Shuriken disparo alternativo",  "Imagenes/Genji/shuriken.png",               "Lanza 3 proyectiles en un arco."));
        habGenji.add(new Habilidad("habilidad",      "Corte veloz",                   "Imagenes/Genji/dash_genji.png",             "Carga rápidamente hacia delante y dañas a los enemigos. Las eliminaciones reinician el tiempo de reutilización."));
        habGenji.add(new Habilidad("habilidad",      "Desvío",                        "Imagenes/Genji/deflect.png",                "Desvías los proyectiles recibidos hacia la dirección en la que miras y bloqueas ataques cuerpo a cuerpo."));
        habGenji.add(new Habilidad("definitiva",     "Hoja del dragón",               "Imagenes/Genji/dragon_blade.png",           "Desenfundas un arma cuerpo a cuerpo mortifera."));
        service.guardar(new Heroe("genji", "Genji", "dps", "El cíborg ninja Genji Shimada ha aceptado el cuerpo potenciado que rechazó en el pasado y, gracias a ello, ha descubierto una humanidad superior.", "Imagenes/Genji/portada_genji.png", 250, habGenji));

        // --- Hanzo ----------------------------------------------------------
        List<Habilidad> habHanzo = new ArrayList<>();
        habHanzo.add(new Habilidad("pasivaRol",      "Función: Daño",         "Imagenes/habilidades_comunes/rol_dps.svg", "Dañar a un enemigo reduce temporalmente la curación que recibe."));
        habHanzo.add(new Habilidad("pasivaPropia",   "Escalada",              "Imagenes/Hanzo/escalada_hanzo.png",        "Saltas hacia una pared para trepar por ella."));
        habHanzo.add(new Habilidad("arma",           "Arco de tormenta",      "Imagenes/Hanzo/arco.png",                  "Mantenlo pulsado para cargar las flechas, y luego suéltalo para dispararlas más lejos."));
        habHanzo.add(new Habilidad("habilidad",      "Tormenta de flechas",   "Imagenes/Hanzo/storm_arrow.png",           "Las siguentes 5 flechas rebotan, se lanzan de forma instantánea e inflingen daño reducido."));
        habHanzo.add(new Habilidad("habilidad",      "Flecha sónica",         "Imagenes/Hanzo/sonic_arrow.png",           "Tras impactar, revela a los enemigos durante un breve período de tiempo."));
        habHanzo.add(new Habilidad("habilidad",      "Agilidad de dragón",    "Imagenes/Hanzo/salto_extra_hanzo.png",     "Tiene doble salto."));
        habHanzo.add(new Habilidad("definitiva",     "Ataque del dragón",     "Imagenes/Hanzo/dragons.png",               "Lanzas un espíritu dragón letal que arrastra con los enemígos que atraviesa."));
        service.guardar(new Heroe("hanzo", "Hanzo", "dps", "Hanzo Shimada no deja de poner a prueba sus habilidades como arquero y asesino para convertirse en un guerrero sin par.", "Imagenes/Hanzo/portada_hanzo.png", 250, habHanzo));

        // --- Junkrat ----------------------------------------------------------
        List<Habilidad> habJunkrat = new ArrayList<>();
        habJunkrat.add(new Habilidad("pasivaRol",   "Función: Daño",    "Imagenes/habilidades_comunes/rol_dps.svg", "Dañar a un enemigo reduce temporalmente la curación que recibe."));
        habJunkrat.add(new Habilidad("pasivaPropia","Caos total",       "Imagenes/Junkrat/pasiva_junkrat.png",      "No sufres daño con tus propios explosivos. Sueltas bombas al morir."));
        habJunkrat.add(new Habilidad("arma",        "Lanzagranadas",    "Imagenes/Junkrat/arma_junkrat.png",        "Arma de proyectiles explosivos que rebotan."));
        habJunkrat.add(new Habilidad("habilidad",   "Mina de conmoción","Imagenes/Junkrat/mina_junkrat.png",        "Lanzas una mina que repeles y detonas."));
        habJunkrat.add(new Habilidad("habilidad",   "Cepo",             "Imagenes/Junkrat/cepo.png",                "Colocas una trampa inmovilizadora."));
        habJunkrat.add(new Habilidad("definitiva",  "Rueda explosiva",  "Imagenes/Junkrat/rip_tire.png",            "Dirige y detonas una rueda explosiva."));
        service.guardar(new Heroe("junkrat", "Junkrat", "dps", "Junkrat es un demoledor fanático de los explosivos que disfruta con el caos y la destrucción.", "Imagenes/Junkrat/portada_junkrat.png", 250, habJunkrat));

        // --- Mei ----------------------------------------------------------
        List<Habilidad> habMei = new ArrayList<>();
        habMei.add(new Habilidad("pasivaRol",   "Función: Daño",          "Imagenes/habilidades_comunes/rol_dps.svg",  "Dañar a un enemigo reduce temporalmente la curación que recibe."));
        habMei.add(new Habilidad("arma",        "Pistola endotérmica",    "Imagenes/Mei/blaster.png",                  "Arma de rociado de corto alcance que realentiza a los enemigos."));
        habMei.add(new Habilidad("arma",        "Carámbano",              "Imagenes/Mei/carambano.png",                "Lanzacarámbanos de largo alcance."));
        habMei.add(new Habilidad("habilidad",   "Criónica",               "Imagenes/Mei/cube.png",                     "Te vuelves invulnerable y te sanas."));
        habMei.add(new Habilidad("habilidad",   "Muro de Hielo",          "Imagenes/Mei/ice_wall.png",                 "Creas un muro de hielo."));
        habMei.add(new Habilidad("definitiva",  "Ventisca",               "Imagenes/Mei/blizzard.png",                 "Lanzas un dron de control climático que congela a los enemigos en una gran área."));
        service.guardar(new Heroe("mei", "Mei", "dps", "Mei es una científica que ha decidido convertir la protección de la naturaleza en su lucha personal.", "Imagenes/Mei/portada_mei.png", 300, habMei));

        // --- Pharah ----------------------------------------------------------
        List<Habilidad> habPharah = new ArrayList<>();
        habPharah.add(new Habilidad("pasivaRol",      "Función: Daño",        "Imagenes/habilidades_comunes/rol_dps.svg",    "Dañar a un enemigo reduce temporalmente la curación que recibe."));
        habPharah.add(new Habilidad("pasivaPropia",   "Planeador",            "Imagenes/Pharah/pasiva_pharah.png",           "Mantén pulsado para planear. Caes despacio cuando el combustible se termina. El combustible solo se regenera mientras se está en el suelo."));
        habPharah.add(new Habilidad("arma",           "Lanzacohetes",         "Imagenes/Pharah/rocket_launcher.png",         "Arma de proyectiles explosivos de largo alcance."));
        habPharah.add(new Habilidad("habilidad",      "Propulsores",          "Imagenes/Pharah/jump_jet.png",                "Asciendes rápidamente y recuperas un poco de combustible."));
        habPharah.add(new Habilidad("habilidad",      "Disparo de conmoción", "Imagenes/Pharah/concussive_blast.png",        "Lanzas un cohete explosivo que repele a los enemigos."));
        habPharah.add(new Habilidad("habilidad",      "Impulso",              "Imagenes/Pharah/jet_dash.png",                "Te impulsas horizontalmente."));
        habPharah.add(new Habilidad("definitiva",     "Bombardeo",            "Imagenes/Pharah/barrage.png",                 "Lanzas una salva continua de minicohetes."));
        service.guardar(new Heroe("pharah", "Pharah", "dps", "Fareeha Amari lleva la llamada del deber en la sangre. Procede de un largo linaje de soldados condecorados y su mayor afán es servir con honor.", "Imagenes/Pharah/portada_pharah.png", 225, habPharah));

        // --- Reaper ----------------------------------------------------------
        List<Habilidad> habReaper = new ArrayList<>();
        habReaper.add(new Habilidad("pasivaRol",      "Función: Daño",        "Imagenes/habilidades_comunes/rol_dps.svg",    "Dañar a un enemigo reduce temporalmente la curación que recibe."));
        habReaper.add(new Habilidad("pasivaPropia",   "Siega",                "Imagenes/Reaper/pasiva_reaper.png",           "Infligir daño te sana."));
        habReaper.add(new Habilidad("arma",           "Escopetas infernales", "Imagenes/Reaper/shotguns.png",                "Armas de corto alcance y disparo esparcido."));
        habReaper.add(new Habilidad("habilidad",      "Paso de las tinieblas","Imagenes/Reaper/tp.png",                      "Te teletransportas a la ubicación seleccionada."));
        habReaper.add(new Habilidad("habilidad",      "Forma espectral",      "Imagenes/Reaper/fade.png",                    "Aceleras tu movimiento y te vuelves invulnerable, pero no puedes disaparar."));
        habReaper.add(new Habilidad("habilidad",      "Gatillos calamitosos", "Imagenes/Reaper/double_shot.png",             "Dispara una descarga de precisión de largo alcance con ambas Escopetas infernales."));
        habReaper.add(new Habilidad("definitiva",     "Espiral de muerte",    "Imagenes/Reaper/blossom.png",                 "Dañas a todos los enemigos cercanos."));
        service.guardar(new Heroe("reaper", "Reaper", "dps", "Corren rumores de la existencia de un terrorista vestido de negro conocido como «Reaper». Su verdadera identidad y sus objetivos son un misterio. Solo hay una cosa segura: donde él va, la muerte lo sigue.", "Imagenes/Reaper/portada_reaper.png", 300, habReaper));

        // --- Sierra ----------------------------------------------------------
        List<Habilidad> habSierra = new ArrayList<>();
        habSierra.add(new Habilidad("pasivaRol",      "Función: Daño",      "Imagenes/habilidades_comunes/rol_dps.svg",    "Dañar a un enemigo reduce temporalmente la curación que recibe."));
        habSierra.add(new Habilidad("arma",           "Rifle hélice",       "Imagenes/Sierra/arma_sierra.png",             "Arma de asalto automática. Dispara en forma de hélice, obteniendo precisión con fuego sostenido."));
        habSierra.add(new Habilidad("habilidad",      "Disparo rastreador", "Imagenes/Sierra/tracking_shot.png",           "Marca a un enemigo. Los disparos del rifle hélice rastrean automáticamente a los enemigos marcados."));
        habSierra.add(new Habilidad("habilidad",      "Dron de anclaje",    "Imagenes/Sierra/dron.png",                    "Lanzas un dron de anclaje. Reactívalo para lanzarte hacia él."));
        habSierra.add(new Habilidad("habilidad",      "Carga sísmica",      "Imagenes/Sierra/granade.png",                 "Lanzas una carga que crea una onda de choque al impactar."));
        habSierra.add(new Habilidad("definitiva",     "Abrecaiminos",       "Imagenes/Sierra/trailblazer.png",             "Despliegas un dron que vuela hacia delante y lanza explosivos."));
        service.guardar(new Heroe("sierra", "Sierra", "dps", "Una compañera de equipo con habilidades mejoradas, Sierra, ha ascendido en las filas de Helix Security. Con su actitud positiva no hay desafío al que no pueda enfrentarse.", "Imagenes/Sierra/portada_sierra.png", 250, habSierra));

        // --- Sojourn ----------------------------------------------------------
        List<Habilidad> habSojourn = new ArrayList<>();
        habSojourn.add(new Habilidad("pasivaRol",      "Función: Daño",           "Imagenes/habilidades_comunes/rol_dps.svg",     "Dañar a un enemigo reduce temporalmente la curación que recibe."));
        habSojourn.add(new Habilidad("arma",           "Cañón de riel",           "Imagenes/Sojourn/railgun.png",                 "Proyectiles de gran velocidad que generan energía al impactar."));
        habSojourn.add(new Habilidad("arma",           "Disparo cargado",         "Imagenes/Sojourn/disparo_cargado.png",         "Disparo de potencia elevada que gasta la energía acumulada y atraviesa a los enemigos."));
        habSojourn.add(new Habilidad("habilidad",      "Maniobra evasiva",        "Imagenes/Sojourn/slide.png",                   "Desplazamiento por el suelo que puede convertirse en un salto elevado."));
        habSojourn.add(new Habilidad("habilidad",      "Disparo inmovilizador",   "Imagenes/Sojourn/disruptor.png",               "Lanzas una ráfaga de energía que inflige daño a los enemigos que se encuentren en su interior."));
        habSojourn.add(new Habilidad("definitiva",     "Supercarga",              "Imagenes/Sojourn/overclock.png",               "La energía del cañón de riel se carga automáticamente durante un breve periodo."));
        service.guardar(new Heroe("sojourn", "Sojourn", "dps", "Como líder de la antigua Overwatch, Vivian Chase «Sojourn» tiene claro que no permitirá que los héroes nuevos repitan los errores del pasado.", "Imagenes/Sojourn/portada_soj.png", 225, habSojourn));

        // --- Soldado: 76 ----------------------------------------------------------
        List<Habilidad> habSoldado76 = new ArrayList<>();
        habSoldado76.add(new Habilidad("pasivaRol",      "Función: Daño",            "Imagenes/habilidades_comunes/rol_dps.svg",   "Dañar a un enemigo reduce temporalmente la curación que recibe."));
        habSoldado76.add(new Habilidad("arma",           "Rifle de pulsos pesado",   "Imagenes/Soldado76/arma_soldier.png",        "Arma de asalto automática."));
        habSoldado76.add(new Habilidad("habilidad",      "Sprint",                   "Imagenes/Soldado76/sprint.png",              "Corres más rápido hacia delante."));
        habSoldado76.add(new Habilidad("habilidad",      "Campo biótico",            "Imagenes/Soldado76/biotic_field.png",        "Despliegas un campo que sana a tus aliados y a ti."));
        habSoldado76.add(new Habilidad("habilidad",      "Cohetes Hélice",           "Imagenes/Soldado76/helix.png",               "Lanzas una salva de cohetes explosivos."));
        habSoldado76.add(new Habilidad("definitiva",     "Visor táctico",            "Imagenes/Soldado76/visor.png",               "Apuntas tu arma automáticamente a los objetivos visibles."));
        service.guardar(new Heroe("soldado76", "Soldado: 76", "dps", "El justiciero conocido como Soldado: 76, en busca y captura por todo el mundo, libra una guerra personal para revelar la verdad que hay detrás de la caída de Overwatch.", "Imagenes/Soldado76/portada_soldier.png", 250, habSoldado76));

        // --- Sombra ----------------------------------------------------------
        List<Habilidad> habSombra = new ArrayList<>();
        habSombra.add(new Habilidad("pasivaRol",      "Función: Daño",              "Imagenes/habilidades_comunes/rol_dps.svg",     "Dañar a un enemigo reduce temporalmente la curación que recibe."));
        habSombra.add(new Habilidad("pasivaPropia",   "Oportunista",                "Imagenes/Sombra/pasiva_sombra.png",            "Puedes ver cuándo los héroes enemigos tienen la habilidad definitiva disponible e infliges más daño a los enemigos hackeados."));
        habSombra.add(new Habilidad("arma",           "Subfusil",                   "Imagenes/Sombra/arma_sombra.png",              "Arma automática de corto alcance."));
        habSombra.add(new Habilidad("habilidad",      "Hackeo",                     "Imagenes/Sombra/hack.png",                     "Mantén pulsado para hackear. Los enemigos hackeados no pueden usar habilidades y se ven a través de las paredes. Los packs de salud hackeados reaparecen más rápido y los enemigos no pueden usarlos. Sufrir daños interrumpe el hackeo."));
        habSombra.add(new Habilidad("habilidad",      "Virus",                      "Imagenes/Sombra/virus.png",                    "Infectas a los enemigos con un proyectil que inflige daño en el tiempo. El virus daña más rápido a los enemigos hackeados."));
        habSombra.add(new Habilidad("habilidad",      "Baliza de translocación",    "Imagenes/Sombra/tp.png",                       "Lanzas una baliza y te teletransportas hasta ella. Tras teletransportarte, entras en sigilo durante un breve periodo de tiempo."));
        habSombra.add(new Habilidad("definitiva",     "PEM",                        "Imagenes/Sombra/emp.png",                      "Infliges daño a todos los enemigos cercanos según un porcentaje de su salud actual, los hackeas y destruyes las barreras a tu alrededor."));
        service.guardar(new Heroe("sombra", "Sombra", "dps", "Sombra, una de las hackers más notorias del mundo, usa la información para manipular a los poderosos.", "Imagenes/Sombra/portada_sombra.png", 225, habSombra));

        // --- Symmetra ----------------------------------------------------------
        List<Habilidad> habSymmetra = new ArrayList<>();
        habSymmetra.add(new Habilidad("pasivaRol",    "Función: Daño",          "Imagenes/habilidades_comunes/rol_dps.svg",       "Dañar a un enemigo reduce temporalmente la curación que recibe."));
        habSymmetra.add(new Habilidad("arma",         "Proyector de fotones",   "Imagenes/Symmetra/arma_sym.png",                 "Arma de corto alcance cuyo haz inflige cada vez más daño."));
        habSymmetra.add(new Habilidad("arma",         "Disparo secundario",     "Imagenes/Symmetra/disparo_secundario.png",       "Mantén pulsado para cargar y suéltalo para disparar un orbe explosivo."));
        habSymmetra.add(new Habilidad("habilidad",    "Torreta centinela",      "Imagenes/Symmetra/turret.png",                   "Despliegas una pequeña torreta que daña y ralentiza a los enemigos."));
        habSymmetra.add(new Habilidad("habilidad",    "Teletransportador",      "Imagenes/Symmetra/tp.png",                       "Creas dos teletransportadores temporales que permiten viajar de uno a otro al instante."));
        habSymmetra.add(new Habilidad("definitiva",   "Barrera de fotones",     "Imagenes/Symmetra/photon_barrier.png",           "Despliegas una barrera de energía enorme."));
        service.guardar(new Heroe("symmetra", "Symmetra", "dps", "Symmetra modela la realidad, literalmente. Mediante sus creaciones de luz sólida, es capaz de manipular el mundo de acuerdo con su visión de una sociedad perfecta.", "Imagenes/Symmetra/portada_sym.png", 275, habSymmetra));

        // --- Torbjörn ----------------------------------------------------------
        List<Habilidad> habTorb = new ArrayList<>();
        habTorb.add(new Habilidad("pasivaRol",    "Función: Daño",         "Imagenes/habilidades_comunes/rol_dps.svg",      "Dañar a un enemigo reduce temporalmente la curación que recibe."));
        habTorb.add(new Habilidad("arma",         "Remachadora",           "Imagenes/Torbjorn/rivet_gun.png",               "Arma de largo alcance y baja cadencia de fuego."));
        habTorb.add(new Habilidad("arma",         "Disparo secundario",    "Imagenes/Torbjorn/disparo_secundario.png",      "Arma de corto alcance, poderosa pero poco precisa."));
        habTorb.add(new Habilidad("arma",         "Martillo de forja",     "Imagenes/Torbjorn/hammer.png",                  "Golpeas con el martillo para reparar tu torreta o dañar a un enemigo."));
        habTorb.add(new Habilidad("habilidad",    "Desplegar torreta",     "Imagenes/Torbjorn/turret.png",                  "Despliegas una torreta que se autoconstruye."));
        habTorb.add(new Habilidad("habilidad",    "Sobrecarga",            "Imagenes/Torbjorn/overload.png",                "Obtén salud adicional y mejora tus velocidades de ataque, movimiento y recarga."));
        habTorb.add(new Habilidad("definitiva",   "Fusión nuclear",        "Imagenes/Torbjorn/core.png",                    "Creas charcos de escoria fundida que daña a los enemigos. Inflige daño adicional a la armadura."));
        service.guardar(new Heroe("torbjorn", "Torbjörn", "dps", "En su apogeo, Overwatch poseyó uno de los arsenales más avanzados del planeta, y casi todo provenía del taller de un avezado ingeniero llamado Torbjörn Lindholm.", "Imagenes/Torbjorn/portada_torb.png", 300, habTorb));

        // --- Tracer ----------------------------------------------------------
        List<Habilidad> habTracer = new ArrayList<>();
        habTracer.add(new Habilidad("pasivaRol",    "Función: Daño",         "Imagenes/habilidades_comunes/rol_dps.svg",      "Dañar a un enemigo reduce temporalmente la curación que recibe."));
        habTracer.add(new Habilidad("arma",         "Pistolas de pulsos",    "Imagenes/Tracer/pistols.png",                   "Armas automáticas de corto alcance."));
        habTracer.add(new Habilidad("habilidad",    "Traslación",            "Imagenes/Tracer/blink.png",                     "Te teletransportas en la dirección en la que te estés moviendo."));
        habTracer.add(new Habilidad("habilidad",    "Regresión",             "Imagenes/Tracer/recall.png",                    "Restablece tu ubicación y salud anteriores al viajar atrás en el tiempo."));
        habTracer.add(new Habilidad("definitiva",   "Bomba de pulsos",       "Imagenes/Tracer/pulse_bomb.png",                "Lanza un potente explosivo adhesivo."));
        service.guardar(new Heroe("tracer", "Tracer", "dps", "La exagente de Overwatch conocida como Tracer es una aventurera del espacio-tiempo y una fuerza irrefrenable del bien.", "Imagenes/Tracer/portada_tracer.png", 175, habTracer));

        // --- Vendetta ----------------------------------------------------------
        List<Habilidad> habVendetta = new ArrayList<>();
        habVendetta.add(new Habilidad("pasivaRol",    "Función: Daño",           "Imagenes/habilidades_comunes/rol_dps.svg",     "Dañar a un enemigo reduce temporalmente la curación que recibe."));
        habVendetta.add(new Habilidad("pasivaPropia", "Arremetida",              "Imagenes/Vendetta/pasiva_vendetta.png",        "Golpea enemigos para aumentar la velocidad de movimiento y ataque."));
        habVendetta.add(new Habilidad("arma",         "Colmillo Palatino",       "Imagenes/Vendetta/arma_vendetta.png",          "Espadón de luz sólida. Encadena tajos para terminar con un golpe destructivo por encima de la cabeza."));
        habVendetta.add(new Habilidad("arma",         "Postura de protección",   "Imagenes/Vendetta/warding.png",                "Bloquea con tu espada, reduce el daño frontal y repele los ataques cuerpo a cuerpo. Bloquear daño consume energía."));
        habVendetta.add(new Habilidad("habilidad",    "Espiral de tajos",        "Imagenes/Vendetta/dash.png",                   "Te lanzas hacia delante y realizas un tajo circular."));
        habVendetta.add(new Habilidad("habilidad",    "Corte volador",           "Imagenes/Vendetta/slice.png",                  "Lanza tu espada en la dirección a la que te diriges y luego vuela hacia ella."));
        habVendetta.add(new Habilidad("habilidad",    "Corte proyectado",        "Imagenes/Vendetta/projected_edge.png",         "Disponibles cuando está activa la postura de protección. Consume energía para lanzar un proyectil ancho."));
        habVendetta.add(new Habilidad("definitiva",   "Partemundos",             "Imagenes/Vendetta/sundering_blade.png",        "Atraviesa prácticamente todas las defensas e inflige mucho daño a los enemigos frente a ti."));
        service.guardar(new Heroe("vendetta", "Vendetta", "dps", "Como campeona del Colosseo y miembro de la élite italiana, Vendetta no se detendrá ante nada para reclamar el trono del imperio criminal de su familia. Conocida por su ira explosiva y su crueldad en la batalla, solo hay una cosa que supera su destreza en el combate físico: su ambición sin límites.", "Imagenes/Vendetta/portada_vendetta.png", 275, habVendetta));

        // --- Venture ----------------------------------------------------------
        List<Habilidad> habVenture = new ArrayList<>();
        habVenture.add(new Habilidad("pasivaRol",    "Función: Daño",               "Imagenes/habilidades_comunes/rol_dps.svg",      "Dañar a un enemigo reduce temporalmente la curación que recibe."));
        habVenture.add(new Habilidad("pasivaPropia", "Paliza",                      "Imagenes/Venture/paliza.png",                   "Los ataques cuerpo a cuerpo rápidos infligen más daño."));
        habVenture.add(new Habilidad("pasivaPropia", "Determinación exploradora",   "Imagenes/Venture/determinacion.png",            "El uso de habilidades confiere escudos temporales."));
        habVenture.add(new Habilidad("arma",         "Excavación inteligente",      "Imagenes/Venture/arma_venture.png",             "Lanza una carga sísmica que explota a poca distancia."));
        habVenture.add(new Habilidad("habilidad",    "Enterrarse",                  "Imagenes/Venture/burrow.png",                   "Te entierras y te vuelves invulnerable. Pulsa o mantén para emerger e infligir daño a los enemigos."));
        habVenture.add(new Habilidad("habilidad",    "Perforación",                 "Imagenes/Venture/drill_dash.png",               "Te lanzas hacia delante tanto si estás bajo tierra como en la superficie, lo que hace retroceder a los enemigos. El tiempo de reutilización se recarga más rápido mientras Enterrarse esté activa."));
        habVenture.add(new Habilidad("definitiva",   "Impacto tectónico",           "Imagenes/Venture/tectonic_shock.png",           "Lanza ondas de choque dañinas."));
        service.guardar(new Heroe("venture", "Venture", "dps", "Arqueólogue y exploradore trotamundos, a Venture le apasiona resolver los misterios de la historia.", "Imagenes/Venture/portada_venture.png", 250, habVenture));

        // --- Widowmaker ----------------------------------------------------------
        List<Habilidad> habWidow = new ArrayList<>();
        habWidow.add(new Habilidad("pasivaRol",    "Función: Daño",         "Imagenes/habilidades_comunes/rol_dps.svg",           "Dañar a un enemigo reduce temporalmente la curación que recibe."));
        habWidow.add(new Habilidad("arma",         "Beso de la viuda",      "Imagenes/Widowmaker/arma_widow.png",                 "Arma de asalto automática."));
        habWidow.add(new Habilidad("arma",         "Apuntado",              "Imagenes/habilidades_comunes/apuntado_widow.png",    "Mantén pulsado para usar un rifle de francotirador de largo alcance."));
        habWidow.add(new Habilidad("habilidad",    "Gancho",                "Imagenes/Widowmaker/hook.png",                       "Lanzas un gancho que te sube a una cornisa."));
        habWidow.add(new Habilidad("habilidad",    "Mina venenosa",         "Imagenes/Widowmaker/mine.png",                       "Lanzas una trampa venenosa."));
        habWidow.add(new Habilidad("definitiva",   "Infravisión",           "Imagenes/Widowmaker/walls.png",                      "Permites a tu equipo ver la ubicación de los enemigos."));
        service.guardar(new Heroe("widowmaker", "Widowmaker", "dps", "Widowmaker es la asesina perfecta: una depredadora paciente, eficiente e inmisericorde que no muestra ni emoción ni arrepentimiento.", "Imagenes/Widowmaker/portada_widow.png", 225, habWidow));


        // ========================================================== Apoyos ==========================================================

        // --- Ana ----------------------------------------------------------
        List<Habilidad> habAna = new ArrayList<>();
        habAna.add(new Habilidad("pasivaRol",  "Función: Apoyo",   "Imagenes/habilidades_comunes/rol_supp.svg",       "Empieza a regenerar salud más rápidamente."));
        habAna.add(new Habilidad("arma",       "Rifle biótico",    "Imagenes/Ana/rifle_biotico.png",                  "Rifle de gran alcance que sana a los aliados y daña a los enemigos."));
        habAna.add(new Habilidad("arma",       "Apuntado",         "Imagenes/habilidades_comunes/apuntado_ana.png",   "Mantén pulsado para acercar el zoom."));
        habAna.add(new Habilidad("habilidad",  "Dardo sedante",    "Imagenes/Ana/sleep.png",                          "Dispara un dardo que duerme al enemigo."));
        habAna.add(new Habilidad("habilidad",  "Granada biótica",  "Imagenes/Ana/nade.png",                           "Lanzas una bomba que sana y aumenta la sanación a los aliados; al mismo tiempo, inflinge daño u evita que se puedan sanar los enemigos."));
        habAna.add(new Habilidad("definitiva", "Nanoestimulantes", "Imagenes/Ana/nano.png",                           "Aumenta el daño de un aliado, al tiempo que reduces el daño que este recibe."));
        service.guardar(new Heroe("ana", "Ana", "apoyo", "Ana, una de las fundadoras de Overwatch, usa sus habilidades y experiencia para proteger su hogar y a todos los que le importan.", "Imagenes/Ana/portada_ana.png", 250, habAna));

        // --- Baptiste ----------------------------------------------------------
        List<Habilidad> habBap = new ArrayList<>();
        habBap.add(new Habilidad("pasivaRol",    "Función: Apoyo",             "Imagenes/habilidades_comunes/rol_supp.svg",   "Empieza a regenerar salud más rápidamente."));
        habBap.add(new Habilidad("pasivaPropia", "Exobotas",                   "Imagenes/Baptiste/exo_botas.png",             "Mantén la posición agachada para saltar más alto."));
        habBap.add(new Habilidad("arma",         "Lanzagranadas biótico",      "Imagenes/Baptiste/arma_bap.png",              "Un arma que dispara ráfaga de tres proyectiles."));
        habBap.add(new Habilidad("arma",         "Disparo secundario",         "Imagenes/Baptiste/bap_alt_shot.png",          "Lanza un proyectil sanador que cura a todos los aliados cercanos al punto de impacto."));
        habBap.add(new Habilidad("habilidad",    "Energía regeneradora",       "Imagenes/Baptiste/energia_reg.png",           "Actívalo para curarte a ti mismo y a tus aliados cercanos al instante, con curación adicional con el tiempo. La curación instantánea se duplica para objetivos con menos de la mitad de su salud."));
        habBap.add(new Habilidad("habilidad",    "Campo de inmortalidad",      "Imagenes/Baptiste/lamp.png",                  "Lanza un dispositivo que impide que los aliados mueran. El dispositivo puede destruirse."));
        habBap.add(new Habilidad("definitiva",   "Matriz amplificadora",       "Imagenes/Baptiste/window.png",                "Proyecta una matriz que duplica el daño y la curación de los proyectiles aliados."));
        service.guardar(new Heroe("baptiste", "Baptiste", "apoyo", "Baptiste es un médico de combate y exagente de Talon que ahora usa sus habilidades para ayudar a las víctimas de la guerra.", "Imagenes/Baptiste/portada_bap.png", 250, habBap));

        // --- Brigitte ----------------------------------------------------------
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

        // --- Illari ----------------------------------------------------------
        List<Habilidad> habIllari = new ArrayList<>();
        habIllari.add(new Habilidad("pasivaRol",  "Función: Apoyo",          "Imagenes/habilidades_comunes/rol_supp.svg",   "Empieza a regenerar salud más rápidamente."));
        habIllari.add(new Habilidad("arma",       "Rifle solar",             "Imagenes/Illari/rifle_solar.png",             "Rifle de largo alcance con carga automática."));
        habIllari.add(new Habilidad("arma",       "Disparo secundario",      "Imagenes/Illari/illari_alt_shot.png",         "Rayo curativo de medio alcance que consume energía solar."));
        habIllari.add(new Habilidad("habilidad",  "Helioterapia",            "Imagenes/Illari/torreta_illari.png",          "Despliega una torreta que sana a los aliados."));
        habIllari.add(new Habilidad("habilidad",  "Erupción",                "Imagenes/Illari/erupcion.png",                "Te lanzas en la dirección en la que te estás moviendo y repelas a los enemigos. Mantén pulsado para ascender más alto."));
        habIllari.add(new Habilidad("definitiva", "Sol cautivo",             "Imagenes/Illari/sun.png",                     "Dispara una bola explosiva de energía solar. Los enemigos alcanzados quedan ralentizados y explotan después de recibir mucho daño."));
        service.guardar(new Heroe("illari", "Illari", "apoyo", "Como la última de los guerreros Inti, Illari es un recipiente para el poder del sol. Hará lo que sea para compensar su pasado.", "Imagenes/Illari/portada_illari.png", 250, habIllari));

        // --- Jetpack Cat ----------------------------------------------------------
        List<Habilidad> habCat = new ArrayList<>();
        habCat.add(new Habilidad("pasivaRol",      "Función: Apoyo",             "Imagenes/habilidades_comunes/rol_supp.svg",     "Empieza a regenerar salud más rápidamente."));
        habCat.add(new Habilidad("pasivaPropia",   "Mochila propulsora",         "Imagenes/Cat/jetpack.png",                      "Vuelo permanente."));
        habCat.add(new Habilidad("arma",           "Patiproyectiles bióticos",   "Imagenes/Cat/biotic_pawjectiles.png",           "Expansión de proyectiles a distancia media que sanan aliados o dañan enemigos."));
        habCat.add(new Habilidad("habilidad",      "Vuelo frenético",            "Imagenes/Cat/frenetic_flight.png",              "Acelera en dirección a tu movimiento. La recuperación de combustible se realiza al llevar a otro jugador."));
        habCat.add(new Habilidad("habilidad",      "Línea de vida",              "Imagenes/Cat/lifeline.png",                     "Activa el modo transporte, lo que permite remolcar a un aliado. Aumenta la velocidad de movimiento y sana a tu aliado."));
        habCat.add(new Habilidad("habilidad",      "Ronroneo",                   "Imagenes/Cat/purr.png",                         "Sanación de zona pulsante que aumenta en frecuencia con el tiempo. Repele a los enemigos cercanos cuando se activa."));
        habCat.add(new Habilidad("definitiva",     "Gata secuestradora",         "Imagenes/Cat/catnapper.png",                    "Lánzate hacia un punto del suelo, derribando a enemigos y atrapando al más cercano a ti."));
        service.guardar(new Heroe("jetpackCat", "Jetpack Cat", "apoyo", "Una felina intrépida equipada con el último invento de propulsión a reacción de Brigitte, Jetpack Cat aporta un adorable apoyo aéreo al campo de batalla.", "Imagenes/Cat/portada_jetpack_cat.png", 225, habCat));

        // --- Juno ----------------------------------------------------------
        List<Habilidad> habJuno = new ArrayList<>();
        habJuno.add(new Habilidad("pasivaRol",      "Función: Apoyo",         "Imagenes/habilidades_comunes/rol_supp.svg",   "Empieza a regenerar salud más rápidamente."));
        habJuno.add(new Habilidad("pasivaPropia",   "Cubrebotas marciano",    "Imagenes/Juno/botas_marcianas.png",           "Mientras esté en el aire, presiona el botón de salto para realizar un segundo salto y mantén presionado para flotar."));
        habJuno.add(new Habilidad("arma",           "Mediblaster",            "Imagenes/Juno/mediblaster.png",               "Arma de fuego explosivo que cura a los aliados y daña a los enemigos."));
        habJuno.add(new Habilidad("habilidad",      "Torpedos pulsar",        "Imagenes/Juno/torpedos_pulsar.png",           "Presiona para fijar al objetivo y luego dispara los proyectiles teledirigidos. Cura a los aliados con el tiempo y daña a los enemigos."));
        habJuno.add(new Habilidad("habilidad",      "Hiperanillo",            "Imagenes/Juno/hiperanillo.png",               "Despliega un anillo que aumenta la velocidad de movimiento de los aliados que pasan a través de él."));
        habJuno.add(new Habilidad("habilidad",      "Impulso de planeo",      "Imagenes/Juno/impulso_planeo.png",            "Deslízate horizontalmente con mayor velocidad de movimiento."));
        habJuno.add(new Habilidad("definitiva",     "Rayo orbital",           "Imagenes/Juno/orbit_ray.png",                 "Invoca un rayo que viaja hacia adelante, curando a los aliados y aumentando su daño."));
        service.guardar(new Heroe("juno", "Juno", "apoyo", "Juno, la primera humana nacida en Marte, emplea su tecnología espacial para resolver cualquier problema que entre en su órbita, y está decidida a salvar algún día su planeta natal.", "Imagenes/Juno/portada_juno.png", 225, habJuno));

        // --- Kiriko ----------------------------------------------------------
        List<Habilidad> habKiriko = new ArrayList<>();
        habKiriko.add(new Habilidad("pasivaRol",      "Función: Apoyo",        "Imagenes/habilidades_comunes/rol_supp.svg",     "Empieza a regenerar salud más rápidamente."));
        habKiriko.add(new Habilidad("pasivaPropia",   "Escalada",              "Imagenes/Kiriko/escalada_kiriko.png",           "Satas hacia una pared para trepar por ella."));
        habKiriko.add(new Habilidad("arma",           "Ofuda de sanación",     "Imagenes/Kiriko/ofudas.png",                    "Canalizas una ráfaga de talismanes hacia los aliados seleccionados."));
        habKiriko.add(new Habilidad("arma",           "Kunái",                 "Imagenes/Kiriko/kunai.png",                     "Proyectil arrojadizo de largo alcance."));
        habKiriko.add(new Habilidad("habilidad",      "Paso ligero",           "Imagenes/Kiriko/tp.png",                        "Te teletransportas junto a un aliado."));
        habKiriko.add(new Habilidad("habilidad",      "Suzu de protección",    "Imagenes/Kiriko/suzu.png",                      "Lanzas un amuleto protector que vuelve invulnerable a los aliados durante unos instantes y elimina la mayoría de los efectos negativos."));
        habKiriko.add(new Habilidad("definitiva",     "Marcha kitsune",        "Imagenes/Kiriko/kitsune.png",                   "Invocas el espíritu de un zorro que avanza hacia delante y potencia el movimiento, la velocidad de ataque y los tiempos de reutilización de los aliados que sigan el camino."));
        service.guardar(new Heroe("kiriko", "Kiriko", "apoyo", "Como miko del santuario de Kanezaka e hija de la antigua maestra espadachina de los Shimada, Kiriko Kamori canaliza sus habilidades espirituales y de ninja para sanar su fracturada ciudad.", "Imagenes/Kiriko/portada_kiriko.png", 225, habKiriko));

        // --- Lifeweaver ----------------------------------------------------------
        List<Habilidad> habLifeweaver = new ArrayList<>();
        habLifeweaver.add(new Habilidad("pasivaRol",      "Función: Apoyo",           "Imagenes/habilidades_comunes/rol_supp.svg",     "Empieza a regenerar salud más rápidamente."));
        habLifeweaver.add(new Habilidad("arma",           "Brote sanador",            "Imagenes/Lifeweaver/healing_blossom.png",       "Mantén pulsado para cargar una sanación y sueltalo para sanar al aliado seleccionado.<br>Se carga pasivamente a una velocidad reducida cuando no se utiliza."));
        habLifeweaver.add(new Habilidad("arma",           "Salva de espinas",         "Imagenes/Lifeweaver/espinas.png",               "Dispara rápidamente proyectiles a pares."));
        habLifeweaver.add(new Habilidad("habilidad",      "Plataforma petaloide",     "Imagenes/Lifeweaver/platform.png",              "Lanza una plataforma que se eleva cuando alguien se sube. Se reinicia cuando no se utiliza."));
        habLifeweaver.add(new Habilidad("habilidad",      "Paso regenerador",         "Imagenes/Lifeweaver/dash.png",                  "Cargas hacia la dirección de desplazamiento y te curas un poco."));
        habLifeweaver.add(new Habilidad("habilidad",      "Agarre vital",             "Imagenes/Lifeweaver/grip.png",                  "Atraes un aliado a tu ubicación y lo proteges durante el recorrido."));
        habLifeweaver.add(new Habilidad("definitiva",     "Árbol de vida",            "Imagenes/Lifeweaver/tree.png",                  "Plantas un árbol qye brota y sana a los aliados al instante. Otorga sanación continua mientas vive."));
        service.guardar(new Heroe("lifeweaver", "Lifeweaver", "apoyo", "El genio creador de la bioluz, una tecnología que combina materia vegetal con luz sólida. Sueña con sanar el mundo.", "Imagenes/Lifeweaver/portada_lifeweaver.png", 250, habLifeweaver));

        // --- Lucio ----------------------------------------------------------
        List<Habilidad> habLucio = new ArrayList<>();
        habLucio.add(new Habilidad("pasivaRol",      "Función: Apoyo",         "Imagenes/habilidades_comunes/rol_supp.svg",    "Empieza a regenerar salud más rápidamente."));
        habLucio.add(new Habilidad("pasivaPropia",   "Trotamuros",             "Imagenes/Lucio/wall_ride.png",                 "Saltas a una pared para impulsarte por ella."));
        habLucio.add(new Habilidad("arma",           "Amplificador sónico",    "Imagenes/Lucio/arma_lucio.png",                "Lanzador de proyectiles sónicos."));
        habLucio.add(new Habilidad("habilidad",      "Cambio de pista",        "Imagenes/Lucio/crossfade.png",                 "Alternas entre dos canciones. Mejora de sanación sana a los aliados cercanos. Mejora de velocidad hace que los aliados cercanos se muevan más rápidos."));
        habLucio.add(new Habilidad("habilidad",      "Subidón",                "Imagenes/Lucio/amp_it_up.png",                 "Aumenta la eficacia de tu canción actual."));
        habLucio.add(new Habilidad("habilidad",      "Onda sonora",            "Imagenes/Lucio/boop.png",                      "Provocas una explosión de corto alcance que repele a los enemigos."));
        habLucio.add(new Habilidad("definitiva",     "Barrera de sonido",      "Imagenes/Lucio/beat.png",                      "Creas salud adicional temporal para los aliados cercanos."));
        service.guardar(new Heroe("lucio", "Lucio", "apoyo", "Lúcio es una celebridad conocida internacionalmente que inspira el cambio social a través de su música y el activismo.", "Imagenes/Lucio/portada_lucio.png", 225, habLucio));

        // --- Mercy ----------------------------------------------------------
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
        service.guardar(new Heroe("mercy", "Mercy", "apoyo", "Además de una sanadora sin par y un auténtico ángel de la guarda para sus pacientes, la doctora Angela Ziegler es una científica brillante y una defensora acérrima de la paz.", "Imagenes/Mercy/portada_mercy.png", 225, habMercy));

        // --- Mizuki ----------------------------------------------------------
        List<Habilidad> habMizuki = new ArrayList<>();
        habMizuki.add(new Habilidad("pasivaRol",      "Función: Apoyo",        "Imagenes/habilidades_comunes/rol_supp.svg",  "Empieza a regenerar salud más rápidamente."));
        habMizuki.add(new Habilidad("pasivaPropia",   "Aura reparadora",       "Imagenes/Mizuki/pasiva_mizuki.png",          "Sana a los aliados cercanos. Es más fuerte al infligir daño y sanar a otros."));
        habMizuki.add(new Habilidad("arma",           "Guja espiritual",       "Imagenes/Mizuki/arma_mizuki.png",            "Un proyectil que rebota y daña a los enemigos."));
        habMizuki.add(new Habilidad("habilidad",      "Sanación Kasa",         "Imagenes/Mizuki/kasa.png",                   "Lanza tu sombrero para que rebote entre los aliados y los sane."));
        habMizuki.add(new Habilidad("habilidad",      "Cadena vinculante",     "Imagenes/Mizuki/chain.png",                  "Lanza una cadena a un enemigo que frena su movimiento."));
        habMizuki.add(new Habilidad("habilidad",      "Regreso Katashiro",     "Imagenes/Mizuki/return.png",                 "Da un salto hacia delante y obtén velocidad de movimiento aumentada. Vuelve a activarlo para teletransportarte de vuelta."));
        habMizuki.add(new Habilidad("definitiva",     "Santuario Kekkai",      "Imagenes/Mizuki/sanctuary.png",              "Crea un santuario que sana a los aliados en su interior y absorbe los proyectiles del enemigo que lo atraviesan."));
        service.guardar(new Heroe("mizuki", "Mizuki", "apoyo", "Nacido bajo la sombra de la desgracia, Mizuki hará todo lo que sea necesario para liberarse de su maldición y ser el dueño de su propio destino.", "Imagenes/Mizuki/portada_mizuki.png", 250, habMizuki));

        // --- Moira ----------------------------------------------------------
        List<Habilidad> habMoira = new ArrayList<>();
        habMoira.add(new Habilidad("pasivaRol",      "Función: Apoyo",              "Imagenes/habilidades_comunes/rol_supp.svg",   "Empieza a regenerar salud más rápidamente."));
        habMoira.add(new Habilidad("arma",           "Rayo biótico",                "Imagenes/Moira/arma_moira.png",               "Mantén pulsado para sanar a todos los aliados frente a ti. Consumes energía biótica."));
        habMoira.add(new Habilidad("arma",           "Disparo secundario",          "Imagenes/Moira/disparo_secundario.png",       "Arma con haz de largo alcance. El daño infligido te sana y repone tu energía biótica."));
        habMoira.add(new Habilidad("habilidad",      "Orbe biótico",                "Imagenes/Moira/biotic_orb.png",               "Dispara una bola que rebota y que sana a los aliados cercanos o daña a los enemigos cercanos."));
        habMoira.add(new Habilidad("habilidad",      "Evanescencia",                "Imagenes/Moira/fade.png",                     "Desapareces, aceleras tu movimiento y te vuelves invulnerable, pero dejas de disparar."));
        habMoira.add(new Habilidad("definitiva",     "Coalescencia",                "Imagenes/Moira/coal.png",                     "Disparas un haz que sana a los aliados y daña a los enemigos."));
        service.guardar(new Heroe("moira", "Moira", "apoyo", "La científica Moira O'Deorain, brillante y controvertida a partes iguales, está a la última en ingeniería genética y busca una forma de sobrescribir los componentes fundamentales que dan forma a la vida.", "Imagenes/Moira/portada_moira.png", 225, habMoira));

        // --- Wuyang ----------------------------------------------------------
        List<Habilidad> habWuyang = new ArrayList<>();
        habWuyang.add(new Habilidad("pasivaRol",    "Función: Apoyo",       "Imagenes/habilidades_comunes/rol_supp.svg",        "Empieza a regenerar salud más rápidamente."));
        habWuyang.add(new Habilidad("arma",         "Bastón de Xuanwu",     "Imagenes/Wuyang/staff.png",                        "Dispara un orbe de agua dañino. Mantén para controlar su trayectoria y potenciar la explosión."));
        habWuyang.add(new Habilidad("arma",         "Flujo restaurativo",   "Imagenes/Wuyang/stream.png",                       "Dirige un flujo sanador pasivo hacia un aliado. Mantén sobre el objetivo para sanar manualmente a un ritmo más rápido, lo que consume recursos de sanación."));
        habWuyang.add(new Habilidad("habilidad",    "Ola guardiana",        "Imagenes/Wuyang/wave.png",                         "Envía una ola hacia delante que aumenta la cantidad de sanación que reciben los aliados y repele a los enemigos."));
        habWuyang.add(new Habilidad("habilidad",    "Torrente impetuoso",   "Imagenes/Wuyang/torrent.png",                      "Deslízate sobre el agua para moverte más rápido y saltar más alto."));
        habWuyang.add(new Habilidad("definitiva",   "Estallido de marea",   "Imagenes/Wuyang/tidal.png",                        "Protege a un aliado o a ti mismo con agua que detona tras unos instantes. La explosión derriva a los enemigos y sana enormemente al objetivo protegido."));
        service.guardar(new Heroe("wuyang", "Wuyang", "apoyo", "Portador de tecnología sanadora de la Facultad del Agua de la Universidad de Wuxing, Wuyang siempre está listo para aguarles la fiesta a los enemigos.", "Imagenes/Wuyang/portada_wuyang.png", 225, habWuyang));

        // --- Zenyatta ----------------------------------------------------------
        List<Habilidad> habZen = new ArrayList<>();
        habZen.add(new Habilidad("pasivaRol",      "Función: Apoyo",       "Imagenes/habilidades_comunes/rol_supp.svg",     "Se cura automáticamente tras un breve periodo sin recibir daño."));
        habZen.add(new Habilidad("pasivaPropia",   "Patada veloz",         "Imagenes/Zenyatta/kick.png",                       "El daño de los ataques cuerpo a cuerpo aumenta un 50% y la repulsión aumenta de forma considerable."));
        habZen.add(new Habilidad("arma",           "Orbe de destrucción",  "Imagenes/Zenyatta/arma_zen.png",                   "Arma de proyectiles de energía. Cárgalo para lanzar más proyectiles."));
        habZen.add(new Habilidad("habilidad",      "Orbe de discordia",    "Imagenes/Zenyatta/discord.png",                    "Lanzas este orbe a un enemigo para aumentar el daño que sufre."));
        habZen.add(new Habilidad("habilidad",      "Orbe de armonía",      "Imagenes/Zenyatta/harmony.png",                    "Lanzas este orbe a un aliado para sanarlo."));
        habZen.add(new Habilidad("definitiva",     "Trascendencia",        "Imagenes/Zenyatta/trans.png",                      "Te vuelves invulnerable, te mueves más rápido y sanas a los aliados cercanos."));
        service.guardar(new Heroe("zenyatta", "Zenyatta", "apoyo", "Zenyatta es un monje ómnico que recorre el mundo en busca de iluminación espiritual. Se dice que todo aquel que se lo encuentra por el camino nunca vuelve a ser el mismo.", "Imagenes/Zenyatta/portada_zen.png", 250, habZen));

    }

    // GET → devuelve todos los héroes
    @GetMapping("/heroes")
    public List<Heroe> getHeroes() {
        return service.listar();
    }

    // GET → devuelve un héroe por su id
    @GetMapping("/heroes/{id}")
    public Heroe getHeroe(@PathVariable String id) {
        return service.buscarPorId(id);
    }

    // POST → añade un héroe nuevo
    @PostMapping("/heroes")
    public Heroe addHeroe(@RequestBody Heroe heroe) {
        return service.guardar(heroe);
    }

    // DELETE → elimina un héroe
    @DeleteMapping("/heroes/{id}")
    public void deleteHeroe(@PathVariable String id) {
        service.eliminar(id);
    }

    // PUT → edita un héroe
    @PutMapping("/heroes/{id}")
    public Heroe updateHeroe(@PathVariable String id, @RequestBody Heroe heroe) {
        return service.actualizar(id, heroe);
    }

}