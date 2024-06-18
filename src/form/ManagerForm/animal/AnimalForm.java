package form.ManagerForm.animal;

import java.awt.CardLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

import form.ManagerForm.ManagerForm;
import form.ManagerForm.employee.EmployeeForm;
import project_zoo.Entity.Animal;
import project_zoo.Entity.Enclosure;
import project_zoo.Query.AnimalDietQuery;
import project_zoo.Query.AnimalHealthQuery;
import project_zoo.Query.AnimalQuery;
import project_zoo.Query.EnclosureQuery;

public class AnimalForm extends javax.swing.JFrame {

    /**
     * Creates new form choose
     */
	private List<Animal> listA;
    public AnimalForm() {
        initComponents();
        setTitle("Quản lí Động vật");
        setLocationRelativeTo(null);
        
    }

    public JPanel getFrame() {
    	return jPanel2;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
 // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {
    	jComboBox1 = new javax.swing.JComboBox<>();
        jDialog1 = new javax.swing.JDialog();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        search1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        area1 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        gender1 = new javax.swing.JTextField();
        birth1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        from1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        category1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        name1 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jLabel1.setText("jLabel1");

        try {
			List<Enclosure> listE = EnclosureQuery.getAllEnclosure();
			List<String> option = new ArrayList<>();
			for(Enclosure x : listE) {
				option.add("" + x.getId());
			}
			DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(option.toArray(new String[0]));
			jComboBox1 = new JComboBox<>(model);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jButton3.setBackground(new java.awt.Color(204, 204, 255));
        jButton3.setText("Xóa động vật");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        search1.setBackground(new java.awt.Color(204, 204, 255));
        search1.setText("Tìm kiếm");
        search1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search1ActionPerformed(evt);
            }
        });
        jLabel7.setText("Ngày sinh");
        jLabel8.setText("Khu vực");
        jLabel2.setText("Giới tính");
        jLabel4.setText("Nguồn gốc");
        jLabel5.setText("Thể loại");

        jButton1.setBackground(new java.awt.Color(204, 204, 255));
        jButton1.setText("Thêm động vật");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });



        jButton2.setBackground(new java.awt.Color(204, 204, 255));
        jButton2.setText("Cập nhật động vật");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        search2 = new javax.swing.JButton();

        search2.setBackground(new java.awt.Color(204, 204, 255));

        search2.setText("Làm mới");

        search2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search2ActionPerformed(evt);
            }
        });
        jLabel6.setText("Tên");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                },
                new String [] {
                    "ID", "Tên", "Giới tính", "Nguồn gốc", "Thể loại", "Ngày sinh", "khu vực"
                }
            ));
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            try {
            	listA = AnimalQuery.getListAnimal(new Animal());
            	for(Animal x : listA) {
            		model.addRow(new Object[] {x.getId(), x.getName(), x.getGender(), x.getSource(), x.getCategory(),
            				x.getDateOfBirth(), x.getEnclosureid()});
            	}
            }catch(Exception ex) {
            	ex.printStackTrace();
            }
        jTable1.setSelectionBackground(new java.awt.Color(255, 255, 255));
        jTable1.setShowGrid(true);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(10);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(100);
            jTable1.getColumnModel().getColumn(5).setPreferredWidth(60);
            jTable1.getColumnModel().getColumn(6).setPreferredWidth(40);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(20, 20, 20))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(category1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(name1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(gender1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(0, 0, 0)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(from1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(birth1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(45, 45, 45)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(search1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(search2, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(55, Short.MAX_VALUE))))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {birth1, category1, from1, gender1, name1});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(name1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(gender1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7)
                    .addComponent(birth1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(search1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(category1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(from1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(search2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>                          

    private void search1ActionPerformed(java.awt.event.ActionEvent evt) {                                        
    	Animal data = new Animal();
    	data.setName(name1.getText());
    	data.setGender(gender1.getText());
    	data.setCategory(category1.getText());
    	if(!jComboBox1.getSelectedItem().equals("")) {
    		data.setEnclosureid(Integer.parseInt(jComboBox1.getSelectedItem().toString()));
    	}
    	data.setDateOfBirth(birth1.getText());
    	data.setSource(from1.getText());
    	DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        try {
        	listA = AnimalQuery.getListAnimal(data);
        	
        	// lam sach du lieu cua jtable
        	((DefaultTableModel)jTable1.getModel()).setRowCount(0);
        	for(Animal x : listA) {
        		model.addRow(new Object[] {x.getId(), x.getName(), x.getGender(), x.getSource(), x.getCategory(),
        				x.getDateOfBirth(), x.getEnclosureid()});
        	}
        }catch(Exception ex) {
        	ex.printStackTrace();
        }
    }    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
    	try {
            Animal a = new Animal();
            a.setName(name1.getText());
            a.setGender(gender1.getText());
            a.setDateOfBirth(birth1.getText());
        	a.setSource(from1.getText());
        	a.setCategory(category1.getText());
        	a.setEnclosureid(Integer.parseInt(jComboBox1.getSelectedItem().toString()));
			AnimalQuery.add(a);
			JOptionPane.showMessageDialog(this, "Thêm thành công");
			
            
            refresh();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Thêm thất bại");
			e.printStackTrace();
		}
    }                                        

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {    
    	if(jTable1.getSelectedRows().length == 0) {
    		JOptionPane.showMessageDialog(this, "Vui lòng chọn đối tượng ");
    		return;
    	}
    	
    	Animal a = listA.get(jTable1.getSelectedRow());
        AnimalUpdateForm b = new AnimalUpdateForm();
        b.setText(a);
        b.setVisible(true);
        
    }                                        

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {                                         
       	if(jTable1.getSelectedRows().length == 0) {
    		JOptionPane.showMessageDialog(this, "Vui lòng chọn đối tượng để xóa");
    		return;
    	}
        int result = JOptionPane.showOptionDialog(this,
                "Bạn có chắc muốn xóa ?",
                "Xác nhận",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                null,
                null);
        int x = jTable1.getSelectedRow();
        if(result == 0) {
        	try {
        		int id = listA.get(x).getId();
        		AnimalHealthQuery.delete(id, "animalid");
        		AnimalDietQuery.delete(id, "animalid");
        		AnimalQuery.delete(id,"id");
        		JOptionPane.showMessageDialog(this, "Xóa thành công");
        		refresh();
        	}catch(Exception e) {
        		JOptionPane.showMessageDialog(this, "Xóa thất bại");
        		e.printStackTrace();
        	}
        }
    }                                        

    private void search2ActionPerformed(java.awt.event.ActionEvent evt) {                                        
    	refresh();
    }       
    public void refresh() {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        try {
        	listA = AnimalQuery.getListAnimal(new Animal());
        	((DefaultTableModel)jTable1.getModel()).setRowCount(0);
        	for(Animal x : listA) {
        		model.addRow(new Object[] {x.getId(), x.getName(), x.getGender(), x.getSource(), x.getCategory(),
        				x.getDateOfBirth(), x.getEnclosureid()});
        	}
        }catch(Exception ex) {
        	ex.printStackTrace();
        }
    }
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        ManagerForm a = new ManagerForm();
        a.setVisible(true);
        this.dispose();
    }                                        

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AnimalForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AnimalForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AnimalForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AnimalForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AnimalForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private java.awt.Label label1;
    private javax.swing.JTextField area1;
    private javax.swing.JTextField birth1;
    private javax.swing.JTextField category1;
    private javax.swing.JTextField from1;
    private javax.swing.JTextField gender1;
    private javax.swing.JButton search1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField name1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JButton search2;
    // End of variables declaration                   
}

