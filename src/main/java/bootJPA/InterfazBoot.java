package bootJPA;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;



import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.JSpinner;
import javax.swing.border.EtchedBorder;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.SpinnerNumberModel;

@SpringBootApplication
@EntityScan("bootJPA")
@EnableJpaRepositories("bootJPA")
@ComponentScan(basePackages = "bootJPA")
@EnableTransactionManagement
public class InterfazBoot extends JFrame implements CommandLineRunner {
    

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	@Autowired
	private EmpleadosRepo er;

	@Autowired
	private HotelesRepo hotelr;
	private static final Logger log = LoggerFactory.getLogger(InterfazBoot.class);
	private JTextField txtC;
	private JTextField txtP;
	private JTextField txtEC;
	private JTextField txtAP;
	private JTextField txtDNI;
	private JLabel lresul;
	private JSpinner sp_estr;
	private JSpinner sp_IS;
	private JSpinner sp_IC;
	private JTextField txtN;
	private JTextField txtS3;

	public InterfazBoot() {
		setTitle("Altas Empresa");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 965, 534);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ALTA RESIDENCIA Y ALTA PROFESORE EN RELACION 1.1 BIDERECCIONAL");
		lblNewLabel.setForeground(new Color(0, 0, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(80, 11, 740, 30);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBorder(null);
		scrollPane_2.setBounds(10, 65, 130, 54);
		contentPane.add(scrollPane_2);
		
		txtC = new JTextField();
		scrollPane_2.setViewportView(txtC);
		txtC.setBorder(new TitledBorder(null, "Ciudad", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 205)));
		txtC.setColumns(10);
		
		JButton btnNewButton = new JButton("Insertar Hotel");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				lresul.setText(null);
				String ciudad = txtC.getText().trim();
				String pais = txtP.getText().trim();
				Integer estrellas = (Integer) sp_estr.getValue();
				 
				if (ciudad.isEmpty() || pais.isEmpty() || estrellas == 0) {
					lresul.setText("Error: Los tres campos deben estar llenos");
					return;
				

				}
				if(!hotelr.findByCiudad(ciudad).isEmpty()) {
					lresul.setText("Error: Ciudad ya existe");
					return;
				

				
				}
				Hoteles hotel = new Hoteles();
				hotel.setPais(pais);
				hotel.setCiudad(ciudad);
				hotel.setEstrellas(estrellas);
				hotelr.save(hotel);
				lresul.setText("Ciudad, pais y Estrellas insertado --> " + ciudad +" "+ pais + " "+ estrellas);
				
			
				
			}
		});
		btnNewButton.setForeground(new Color(0, 0, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(28, 130, 314, 30);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBorder(null);
		scrollPane_3.setBounds(141, 65, 138, 54);
		contentPane.add(scrollPane_3);
		
		txtP = new JTextField();
		scrollPane_3.setViewportView(txtP);
		txtP.setColumns(10);
		txtP.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Pais", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 205)));
		
		JScrollPane scrollPane_5 = new JScrollPane();
		scrollPane_5.setBorder(null);
		scrollPane_5.setBounds(661, 65, 103, 54);
		contentPane.add(scrollPane_5);
		
		txtAP = new JTextField();
		scrollPane_5.setViewportView(txtAP);
		txtAP.setColumns(10);
		txtAP.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Apellidos", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 205)));
		
		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBorder(null);
		scrollPane_4.setBounds(478, 65, 92, 54);
		contentPane.add(scrollPane_4);
		
		txtDNI = new JTextField();
		scrollPane_4.setViewportView(txtDNI);
		txtDNI.setColumns(10);
		txtDNI.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "DNI", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 205)));
		
		sp_estr = new JSpinner();
		sp_estr.setToolTipText("Maximo 5 Estrellas");
		sp_estr.setModel(new SpinnerNumberModel(0, 0, 5, 1));
		sp_estr.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Estrellas", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		sp_estr.setBounds(289, 65, 121, 50);
		contentPane.add(sp_estr);
		
		sp_IS = new JSpinner();
		sp_IS.setToolTipText("maximo 3000 de salario");
		sp_IS.setModel(new SpinnerNumberModel(0.0, 0.0, 3000.0, 1.0));
		sp_IS.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), 
				"Salario", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		sp_IS.setBounds(866, 65, 70, 54);
		contentPane.add(sp_IS);
		
		sp_IC = new JSpinner();
		sp_IC.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
		sp_IC.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Categoria", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		sp_IC.setBounds(774, 65, 82, 54);
		contentPane.add(sp_IC);
		
		JButton btnAsociarprof = new JButton("ASOCIAR HOTEL <---->EMPLEADOS");
		btnAsociarprof.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lresul.setText(null);

				// Obtener el nombre de la ciudad
				String ciudadNombre = txtC.getText();
				List<Hoteles> hotelesEnCiudad = hotelr.findByCiudad(ciudadNombre);
				if (hotelesEnCiudad.isEmpty()) {
					lresul.setText("Error: Ciudad no encontrada");
					return;
				}

				// Seleccionar el primer hotel
				Hoteles hotelSeleccionado = hotelesEnCiudad.get(0);

				// Obtener el empleado por DNI
				String dniEmpleado = txtDNI.getText();
				List<Empleados> empleadosEncontrados = er.findByDni(dniEmpleado);
				if (empleadosEncontrados.isEmpty()) {
					lresul.setText("Error: DNI no encontrado");
					return;
				}

				// Asociar empleados al hotel (sobrescribe la lista)
				hotelSeleccionado.setEmpleados(empleadosEncontrados);

				hotelr.save(hotelSeleccionado);
				System.out.println(hotelSeleccionado.toString());

				lresul.setText("HOTEL <--> EMP --> Asociados");
			}
		});

		btnAsociarprof.setForeground(new Color(0, 0, 255));
		btnAsociarprof.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAsociarprof.setBounds(463, 186, 243, 30);
		contentPane.add(btnAsociarprof);
		
		JButton btnNewButton_1_1 = new JButton("Insertar EMPLEADO");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				lresul.setText("");
				String dni = txtDNI.getText().trim();
				String nombre = txtN.getText().trim();
				String apellido = txtAP.getText().trim();
				Double salario = (Double) sp_IS.getValue();
				Integer categoria = (Integer) sp_IC.getValue();

				if (nombre.isEmpty() || apellido.isEmpty() || salario == 0 || categoria == 0 || nombre.isEmpty()) {
					lresul.setText("Error: TODOS los campos deben estar llenos");
					return;
				}
				if (!er.findByDni(nombre).isEmpty()) {
					lresul.setText("Error: Nombre ya existe");
					return;
				}
				Empleados profe = new Empleados();
				profe.setNombre(nombre);
				profe.setApellidos(apellido);
				profe.setDni(dni);
				profe.setSalario(salario);
				profe.setCategoria(categoria);
				er.save(profe);
				lresul.setText("Nombre, Apellido, Edad y Salario insertado --> " + nombre + " " + apellido + " " + dni
						+ " " + salario + " " + categoria);

			}
		});
		btnNewButton_1_1.setForeground(new Color(0, 0, 255));
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1_1.setBounds(707, 130, 221, 30);
		contentPane.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_2 = new JButton("Nº EMPLEADOS CATEGORIA Y SAL");
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {


			}
		});

		btnNewButton_1_2.setForeground(new Color(0, 0, 255));
		btnNewButton_1_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1_2.setBounds(606, 419, 322, 30);
		contentPane.add(btnNewButton_1_2);
		
		JLabel lblNewLabel_2 = new JLabel("3º.- Asociamos Hotel <--> Empleado");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(151, 187, 288, 28);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("1º.- Insertar CIUDAD DE RESIDENCIA");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setBounds(115, 40, 266, 18);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("2º.- Insertar nuevo PROFESOR");
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3_1.setBounds(593, 40, 266, 18);
		contentPane.add(lblNewLabel_3_1);
		
		lresul = new JLabel("");
		lresul.setBorder(new TitledBorder(null, "Warnings", TitledBorder.LEADING, TitledBorder.TOP, null, Color.RED));
		lresul.setFont(new Font("Tahoma", Font.BOLD, 11));
		lresul.setHorizontalAlignment(SwingConstants.CENTER);
		lresul.setBounds(177, 454, 580, 30);
		contentPane.add(lresul);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 337, 269, 85);
		contentPane.add(scrollPane_1);
		
		txtEC = new JTextField();
		scrollPane_1.setViewportView(txtEC);
		txtEC.setColumns(10);
		txtEC.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Listado de empleados por CIUDAD", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 205)));
		
		txtN = new JTextField();
		txtN.setColumns(10);
		txtN.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Nombre", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 205)));
		txtN.setBounds(569, 65, 92, 54);
		contentPane.add(txtN);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(Color.BLUE);
		separator.setBounds(56, 258, 799, 2);
		contentPane.add(separator);
		
		JLabel lblConsultas = new JLabel("CONSULTAS");
		lblConsultas.setHorizontalAlignment(SwingConstants.CENTER);
		lblConsultas.setForeground(Color.BLUE);
		lblConsultas.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblConsultas.setBounds(53, 266, 740, 18);
		contentPane.add(lblConsultas);
		
		JLabel lblNewLabel_3_2 = new JLabel("1º.- Empleados por Ciudad");
		lblNewLabel_3_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3_2.setBounds(13, 294, 266, 18);
		contentPane.add(lblNewLabel_3_2);
		
		JLabel lblNewLabel_3_3 = new JLabel("2ª Valores fijos de HOTELES");
		lblNewLabel_3_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3_3.setBounds(323, 295, 266, 18);
		contentPane.add(lblNewLabel_3_3);
		
		JLabel lblNewLabel_3_4 = new JLabel("3ª Empleados por categoria y salario");
		lblNewLabel_3_4.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3_4.setBounds(648, 295, 266, 18);
		contentPane.add(lblNewLabel_3_4);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(289, 337, 269, 85);
		contentPane.add(scrollPane);
		
		txtS3 = new JTextField();
		scrollPane.setViewportView(txtS3);
		txtS3.setColumns(10);
		txtS3.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Hoteles SPAIN y >3 estrellas", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 205)));
		
		JSpinner sp_cc = new JSpinner();
		sp_cc.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Categoria", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		sp_cc.setBounds(606, 337, 103, 30);
		contentPane.add(sp_cc);
		
		JButton btnNewButton_1_2_1 = new JButton("EMPLEADOS POR CIUDAD");
		btnNewButton_1_2_1.setForeground(Color.BLUE);
		btnNewButton_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1_2_1.setBounds(53, 424, 198, 30);
		contentPane.add(btnNewButton_1_2_1);
		
		JButton btnNewButton_1_2_2 = new JButton("HOTELES DE SPAIN Y > 3*");
		btnNewButton_1_2_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				    List<Hoteles> hoteles = hotelr.findHotelesEspanaTresEstrellas();

				    if (hoteles.isEmpty()) {
				        lresul.setText("No se encontró ningún resultado");
				        txtS3.setText(""); // Limpiar resultados anteriores
				    } else {
				        StringBuilder sb = new StringBuilder();
				        for (Hoteles p : hoteles) {
				            sb.append("idP: ").append(p.getIdH())
				              .append(" - Ciudad: ").append(p.getCiudad())
				              .append(" - País: ").append(p.getPais())
				              .append(" - Estrellas: ").append(p.getEstrellas())
				              .append("\n");
				        }
				        txtS3.setText(hoteles.toString()); // fuera del bucle
				        lresul.setText("Consulta realizada con éxito");
				    }
				} catch (Exception ex) {
				    lresul.setText("⚠️ Error durante la consulta");
				    txtS3.setText("");
				    ex.printStackTrace(); // opcional: para depuración
				}
			}
		});
		btnNewButton_1_2_2.setForeground(Color.BLUE);
		btnNewButton_1_2_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1_2_2.setBounds(333, 424, 198, 30);
		contentPane.add(btnNewButton_1_2_2);
		
		JSpinner sp_sm = new JSpinner();
		sp_sm.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Sal Minimo", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		sp_sm.setBounds(717, 337, 103, 30);
		contentPane.add(sp_sm);
		
		JSpinner sp_SM = new JSpinner();
		sp_SM.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Sal Maximo", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		sp_SM.setBounds(833, 337, 103, 30);
		contentPane.add(sp_SM);
		
		JSpinner sp_resul = new JSpinner();
		sp_resul.setEnabled(false);
		sp_resul.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Resultado", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		sp_resul.setBounds(717, 378, 103, 30);
		contentPane.add(sp_resul);
	}

	public static void main(String args[]) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
// No se debe poner aquí el frame
					SpringApplication.run(InterfazBoot.class, args);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	@Override
	@Transactional
	public void run(String... args) {
		log.info("Inicio correcto");
// Mostrar la ventana principal al iniciar la aplicación
		SwingUtilities.invokeLater(() -> {
			setVisible(true);
		});
		System.out.println("OK");
	}
}
