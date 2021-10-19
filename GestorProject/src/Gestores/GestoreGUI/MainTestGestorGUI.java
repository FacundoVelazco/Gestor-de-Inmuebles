package Gestores.GestoreGUI;

public class MainTestGestorGUI {
    public static void main(String[] args){
        GestorGUI.add(new PanelWrap("panel1",panelTest1.class));
        GestorGUI.add(new PanelWrap("panel2", panelTest2.class));
        GestorGUI.add(new PanelWrap("panel3", panelTest3.class));
        GestorGUI.init("panel1");
    }
}
