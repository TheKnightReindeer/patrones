
public class Labels4 extends javax.swing.JPanel {

    private boolean jltop, jlbottom, jlleft, jlright;
    private String vtop, vbottom, vleft, vright;
    
    public Labels4() {
        initComponents();
        jLabel1.setVisible(false);
        jLabel2.setVisible(false);
        jLabel3.setVisible(false);
        jLabel4.setVisible(false);
        
        jltop = false;
        jlbottom = false;
        jlleft = false;
        jlright = false;
        
        jLabel1.setText(vtop);
        jLabel2.setText(vbottom);
        jLabel3.setText(vleft);
        jLabel4.setText(vright);
    }

    public void setjltop(boolean b){
        if(b == true){
            reveal(jLabel1);
            jltop = b;
        }
        if(b == false){
            hide(jLabel1);
            jltop = b;
        }
    }
    
    public void setjlbottom(boolean b){
        if(b == true){
            reveal(jLabel2);
            jlbottom = b;
        }
        if(b == false){
            hide(jLabel2);
            jlbottom = b;
        }
    }
    
    public void setjlleft(boolean b){
        if(b == true){
            reveal(jLabel3);
            jlleft = b;
        }
        if(b == false){
            hide(jLabel3);
            jlleft = b;
        }
    }
    
    public void setjlright(boolean b){
        if(b == true){
            reveal(jLabel4);
            jlright = b;
        }
        if(b == false){
            hide(jLabel4);
            jlright = b;
        }
    }
    
    public void reveal(javax.swing.JLabel j){
        j.setVisible(true);
    }
    
    public void hide(javax.swing.JLabel j){
        j.setVisible(false);
    }
    
    public void setvtop(String s){
        jLabel1.setText(s);
    }
    
    public void setvbottom(String s){
        jLabel2.setText(s);
    }
    
    public void setvleft(String s){
        jLabel3.setText(s);
    }
    
    public void setvright(String s){
        jLabel4.setText(s);
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        campoTexto1 = new CampoTexto();

        jLabel1.setText("jLabel1");

        jLabel2.setText("jLabel2");

        jLabel3.setText("jLabel3");

        jLabel4.setText("jLabel4");

        campoTexto1.setText("campoTexto1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(170, 170, 170)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(66, 66, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(30, 30, 30)
                        .addComponent(campoTexto1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(jLabel4)
                        .addGap(55, 55, 55))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(178, 178, 178))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(jLabel1)
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(campoTexto1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(45, 45, 45)
                .addComponent(jLabel2)
                .addContainerGap(94, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private CampoTexto campoTexto1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}
