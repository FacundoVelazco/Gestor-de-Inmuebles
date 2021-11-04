package GUI.Panels.AMInmueblePanels;

import GUI.AutoCompletion;
import GUI.Util.TipoPanelAMInmueble;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelUbicacion {
    private JPanel panelUbicacion;
    private JLabel tituloLabel;
    private JPanel panelTitulo;
    private JPanel panelIzquierda;
    private JPanel panelDerecha;
    private JPanel espacioProvincia;
    private JLabel tituloProvinciaLabel;
    private JLabel provinciaLabel;
    private JLabel tituloLocalidadLabel;
    private JComboBox comboBoxLocalidad;
    private JPanel espacioLocalidad;
    private JPanel espacioBarrio;
    private JLabel tituloBarrio;
    private JTextField textFieldBarrio;
    private JCheckBox checkBoxActivador;
    private JTextField textFieldPVDireccion;
    private JTextField textFieldSVDireccion;
    private JTextField textFieldPiso;
    private JTextField textFieldDepartamento;
    private JPanel espacioActivadorLatLong;
    private JLabel tituloActivadorLabel;
    private JPanel espacioDirección;
    private JLabel tituloPVDireccionLabel;
    private JLabel tituloSVDireccionLabel;
    private JLabel tituloPisoLabel;
    private JPanel espacioPisoDepto;
    private JPanel espacioDepartamento;
    private JPanel espacioPiso;
    private JLabel errorPVDireccionLabel;
    private JLabel errorSVDireccionLabel;
    private TipoPanelAMInmueble tipo;



    public PanelUbicacion() {


        //Rellenado del combobox con las localidades de la provincia
        AutoCompletion.enable(comboBoxLocalidad);
        for(String s : LOCALIDADES){
            comboBoxLocalidad.addItem(s);
        }
        comboBoxLocalidad.setSelectedItem("Santa Fe");


        //Seteo listener checkbox
        checkBoxActivador.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                limpiarLabelErrores();
                limpiarCamposDireccion();

                if(checkBoxActivador.isSelected()){
                    tituloPVDireccionLabel.setText("Latitud:");
                    tituloSVDireccionLabel.setText("Longitud:");
                }else{
                    tituloPVDireccionLabel.setText("Calle:");
                    tituloSVDireccionLabel.setText("Número:");
                }
            }
        });


    }

    public JPanel getPanelUbicacion() {
        return panelUbicacion;
    }

    public Boolean validarDatos(){
        Boolean primerValorDireccion = true;
        Boolean segundoValorDireccion =true;
        Boolean datosValidadosCorrectamente;

        limpiarLabelErrores();

        if(checkBoxActivador.isSelected()){
            try{
                Double.parseDouble(textFieldPVDireccion.getText());
            }catch(Exception e){
                primerValorDireccion = false;
                errorPVDireccionLabel.setText("Inserte un valor de latitud válido");
            }
            try{
                Double.parseDouble(textFieldSVDireccion.getText());
            }catch(Exception e){
                segundoValorDireccion = false;
                errorSVDireccionLabel.setText("Inserte un valor de longitud válido");
            }
        }else{
            primerValorDireccion = !textFieldSVDireccion.getText().equals("");

            if(!primerValorDireccion){
                errorPVDireccionLabel.setText("Este campo es obligatorio");
            }

            try{
                if(Integer.parseInt(textFieldSVDireccion.getText()) <= 0){
                    throw new Exception();
                }
            }catch(Exception e){
                segundoValorDireccion = false;
                errorSVDireccionLabel.setText("Inserte un valor de número válido");
            }
        }

        datosValidadosCorrectamente = primerValorDireccion && segundoValorDireccion;

        return datosValidadosCorrectamente;
    }

    private void limpiarLabelErrores(){
        errorPVDireccionLabel.setText(" ");
        errorSVDireccionLabel.setText(" ");
    }

    private void limpiarCamposDireccion(){
        textFieldPVDireccion.setText("");
        textFieldSVDireccion.setText("");
    }


    private static final String[] LOCALIDADES = {"Aarón Castellanos(Est. Castellanos)",
            "Acebal",
            "Aguará Grande",
            "Albarellos",
            "Alcorta",
            "Aldao(Est. Casablanca)",
            "Aldao",
            "Alejandra",
            "Álvarez",
            "Alvear",
            "Ambrosetti",
            "Amenábar",
            "Ángel Gallardo",
            "Angélica",
            "Angeloni",
            "Arbilla",
            "Arequito",
            "Arminda",
            "Armstrong",
            "Arocena",
            "Arroyo Aguiar",
            "Arroyo Ceibal",
            "Arroyo Leyes",
            "Arroyo Seco",
            "Arrufó",
            "Arteaga",
            "Ataliva",
            "Aurelia",
            "Avellaneda(Est. Ewald)",
            "Balneario La Verde",
            "Balneario Monje",
            "Barrancas",
            "Barrio Arroyo del Medio",
            "Barrio Caima",
            "Barrio Cicarelli",
            "Barrio El Pacaá - Barrio Comipini",
            "Barrio Mitre",
            "Barrios Acapulco y Veracruz",
            "Bauer y Sigel",
            "Bella Italia",
            "Berabevú",
            "Berna",
            "Bernardo de Irigoyen(Est. Irigoyen)",
            "Bigand",
            "Bombal",
            "Bouquet",
            "Bustinza",
            "Cabal",
            "Cacique Ariacaiquín",
            "Cafferata",
            "Calchaquí",
            "Campo Andino",
            "Cañada de Gómez",
            "Cañada del Ucle",
            "Cañada Ombú",
            "Cañada Rica",
            "Cañada Rosquín",
            "Candioti",
            "Capitán Bermúdez",
            "Capivara",
            "Carcarañá",
            "Carlos Pellegrini",
            "Carmen",
            "Carmen del Sauce",
            "Carreras",
            "Carrizales(Est. Clarke)",
            "Casalegno",
            "Casas",
            "Casilda",
            "Castelar",
            "Castellanos",
            "Cavour",
            "Cayastá",
            "Cayastacito",
            "Centeno",
            "Cepeda",
            "Ceres",
            "Chabás",
            "Chañar Ladeado",
            "Chapuy",
            "Chovet",
            "Christophersen",
            "Classon",
            "Colmena",
            "Colonia Ana",
            "Colonia Belgrano",
            "Colonia Bicha",
            "Colonia Bossi",
            "Colonia Cello",
            "Colonia Dolores",
            "Colonia Durán",
            "Colonia Margarita",
            "Colonia Médici",
            "Colonia Raquel",
            "Colonia Rosa",
            "Constanza",
            "Coronda",
            "Coronel Arnold",
            "Coronel Bogado",
            "Coronel Fraga",
            "Coronel Rodolfo S. Domínguez",
            "Correa",
            "Crispi",
            "Cuatro Esquinas",
            "Cululú",
            "Curupaytí",
            "Desvío Arijón",
            "Díaz",
            "Diego de Alvear",
            "Egusquiza",
            "El Arazá",
            "El Caramelo",
            "Elisa",
            "Elortondo",
            "El Rabón",
            "El Trébol",
            "Emilia",
            "Empalme San Carlos",
            "Empalme Villa Constitución",
            "Esmeralda",
            "Esperanza",
            "Estación Clucellas",
            "Estación Saguier",
            "Esteban Rams",
            "Esther",
            "Eusebia y Carolina",
            "Eustolia",
            "Felicia",
            "Fighiera",
            "Firmat",
            "Firmat",
            "Florencia",
            "Fortín Olmos",
            "Franck",
            "Fray Luis Beltrán",
            "Frontera",
            "Fuentes",
            "Funes",
            "Gaboto",
            "Gálvez",
            "Garabato",
            "Garibaldi",
            "Gato Colorado",
            "General Gelly",
            "General Lagos",
            "Gessler",
            "Gobernador Crespo",
            "Gödeken",
            "Godoy",
            "Golondrina",
            "Granadero Baigorria",
            "Gregoria Pérez de Denis(Est. El Nochero)",
            "Grutly",
            "Guadalupe Norte",
            "Helvecia",
            "Hersilia",
            "Hipatia",
            "Huanqueros",
            "Hughes",
            "Humberto Primo",
            "Humboldt",
            "Ibarlucea",
            "Ibarlucea",
            "Ingeniero Chanourdie",
            "Intiyaco",
            "Irigoyen",
            "Jacinto L. Aráuz",
            "Josefina",
            "Juan Bernabé Molina",
            "Juncal",
            "Kilómetro 101",
            "Kilómetro 115",
            "Labordeboy",
            "La Brava",
            "La Cabral",
            "La Chispa",
            "La Criolla(Est. Cañadita)",
            "La Gallareta",
            "Laguna Paiva",
            "La Isleta",
            "La Lucila",
            "Landeta",
            "Lanteri",
            "La Pelada",
            "La Penca y Caraguatá",
            "Larguía",
            "Larrechea",
            "La Rubia",
            "La Sarita",
            "Las Avispas",
            "Las Bandurrias",
            "Las Garzas",
            "Las Palmeras",
            "Las Parejas",
            "Las Petacas",
            "Las Rosas",
            "Las Toscas",
            "Las Tunas",
            "La Vanguardia",
            "Lazzarino",
            "Lehmann",
            "Llambi Campbell",
            "Logroño",
            "Loma Alta",
            "López(Est. San Martín de Tours)",
            "Los Amores",
            "Los Cardos",
            "Los Laureles",
            "Los Molinos",
            "Los Muchachos - La Alborada",
            "Los Nogales",
            "Los Quirquinchos",
            "Los Zapallos",
            "Lucio V. López",
            "Luis Palacios(Est. La Salada)",
            "Maciel",
            "Maggiolo",
            "Malabrigo",
            "Marcelino Escalada",
            "Margarita",
            "María Juana",
            "María Luisa",
            "María Susana",
            "María Teresa",
            "Matilde",
            "Máximo Paz(Est. Paz)",
            "Melincué(Est. San Urbano)",
            "Miguel Torres",
            "Moisés Ville",
            "Monigotes",
            "Monje",
            "Montefiore",
            "Monte Flores",
            "Montes de Oca",
            "Monte Vera",
            "Murphy",
            "Ñanducita",
            "Naré",
            "Nelson",
            "Nueva Lehmann",
            "Nuevo Torino",
            "Oliveros",
            "Palacios",
            "Paraje 29",
            "Paraje Chaco Chico",
            "Paraje La Costa",
            "Paraje San Manuel",
            "Pavón",
            "Pavón Arriba",
            "Pedro Gómez Cello",
            "Pérez",
            "Peyrano",
            "Piamonte",
            "Pilar",
            "Piñero(Est. Erasto)",
            "Plaza Clucellas",
            "Plaza Matilde",
            "Plaza Saguier",
            "Pozo Borrado",
            "Pozo de los Indios",
            "Presidente Roca",
            "Progreso",
            "Providencia",
            "Pueblo Andino",
            "Pueblo Esther",
            "Pueblo Marini",
            "Pueblo Muñoz(Est. Bernard)",
            "Pueblo Santa Lucía",
            "Pueblo Uranga",
            "Puerto Aragón",
            "Puerto Arroyo Seco",
            "Puerto General San Martín",
            "Puerto Reconquista",
            "Pujato",
            "Rafaela",
            "Ramayón",
            "Ramona",
            "Reconquista",
            "Recreo",
            "Ricardone",
            "Rincón Potrero",
            "Roldán",
            "Romang",
            "Rosario",
            "Rueda",
            "Rufino",
            "Saladero Mariano Cabal",
            "Salto Grande",
            "San Agustín",
            "San Antonio",
            "San Antonio de Obligado",
            "San Bernardo",
            "San Bernardo",
            "San Carlos Centro",
            "San Carlos Norte",
            "San Carlos Sud",
            "San Cristóbal",
            "Sancti Spiritu",
            "San Eduardo",
            "San Eugenio",
            "San Fabián",
            "Sanford",
            "San Francisco de Santa Fe",
            "San Genaro",
            "San Genaro Norte",
            "San Gregorio",
            "San Guillermo",
            "San Javier",
            "San Jerónimo del Sauce",
            "San Jerónimo Norte",
            "San Jerónimo Sud",
            "San Jorge",
            "San José de la Esquina",
            "San José del Rincón",
            "San Justo",
            "San Lorenzo",
            "San Mariano",
            "San Martín de las Escobas",
            "San Martín Norte",
            "Santa Clara de Buena Vista",
            "Santa Clara de Saguier",
            "Santa Fe",
            "Santa Isabel",
            "Santa Margarita",
            "Santa Rosa de Calchines",
            "Santa Teresa",
            "Santo Domingo",
            "Santo Tomé",
            "Santurce",
            "San Vicente",
            "Sa Pereira",
            "Sargento Cabral",
            "Sarmiento",
            "Sastre",
            "Sauce Viejo",
            "Serodino",
            "Silva(Est. Abipones)",
            "Soldini",
            "Soledad",
            "Stephenson",
            "Suardi",
            "Sunchales",
            "Susana",
            "Tacuarendí(Emb. Kilómetro 421)",
            "Tacural",
            "Tartagal(Est. El Tajamar)",
            "Teodelina",
            "Theobald",
            "Timbúes",
            "Toba",
            "Tortugas",
            "Tostado",
            "Totoras",
            "Traill",
            "Venado Tuerto",
            "Vera(Est. Gobernador Vera)",
            "Vera y Pintado(Est. Guaraníes)",
            "Videla",
            "Vila",
            "Villa Amelia",
            "Villa Ana",
            "Villa Cañás",
            "Villa Constitución",
            "Villada",
            "Villa del Plata",
            "Villa Eloísa",
            "Villa Elvira",
            "Villa Gobernador Gálvez",
            "Villa Guillermina",
            "Villa Josefina",
            "Villa la Rivera (Comuna Oliveros)(Villa La Ribera)",
            "Villa la Rivera (Comuna Pueblo Andino)(Villa La Ribera)",
            "Villa Laura(Est. Constituyentes)",
            "Villa Minetti",
            "Villa Mugueta",
            "Villa Ocampo",
            "Villa San José",
            "Villa Saralegui",
            "Villa Trinidad",
            "Virginia",
            "Wheelwright",
            "Wildermuth(Est. Granadero B. Bustos)",
            "Zavalla",
            "Zenón Pereyra"
    };

}
