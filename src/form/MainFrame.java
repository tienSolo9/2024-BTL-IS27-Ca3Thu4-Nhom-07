package form;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    private JPanel mainPanel;

    public MainFrame() {
        setTitle("C S Psyco");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Sidebar panel
        JPanel sidebar = new JPanel();
        sidebar.setLayout(new BoxLayout(sidebar, BoxLayout.Y_AXIS));
        sidebar.setBackground(Color.BLUE);
        
        JLabel title = new JLabel("C S Psyco");
        title.setFont(new Font("Arial", Font.BOLD, 24));
        title.setForeground(Color.WHITE);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        sidebar.add(title);
        sidebar.add(Box.createRigidArea(new Dimension(0, 20)));

        JButton homeButton = createSidebarButton("Home");
        JButton servicesButton = createSidebarButton("Services");
        JButton contactButton = createSidebarButton("Contact");
        JButton aboutButton = createSidebarButton("About");

        sidebar.add(homeButton);
        sidebar.add(servicesButton);
        sidebar.add(contactButton);
        sidebar.add(aboutButton);

        add(sidebar, BorderLayout.WEST);

        // Main content panel
        mainPanel = new JPanel();
        mainPanel.setLayout(new CardLayout());
        add(mainPanel, BorderLayout.CENTER);

        // Add different panels to mainPanel
        mainPanel.add(createHomePanel(), "Home");
        mainPanel.add(createServicesPanel(), "Services");
        mainPanel.add(createContactPanel(), "Contact");
        mainPanel.add(new statisticalForm().getJFrame(), "About");

        // Action listeners for buttons
        homeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showPanel("Home");
            }
        });

        servicesButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showPanel("Services");
            }
        });

        contactButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showPanel("Contact");
            }
        });

        aboutButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showPanel("About");
            }
        });

        // Set initial panel
        showPanel("Home");
    }

    private JButton createSidebarButton(String text) {
        JButton button = new JButton(text);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setMaximumSize(new Dimension(150, 50));
        return button;
    }

    private void showPanel(String panelName) {
        CardLayout cl = (CardLayout)(mainPanel.getLayout());
        cl.show(mainPanel, panelName);
    }

    private JPanel createHomePanel() {
        JPanel panel = new JPanel();
        panel.setBackground(Color.PINK);
        JLabel label = new JLabel(new ImageIcon("path/to/your/home/icon.png")); // Adjust path to your image
        panel.add(label);
        JLabel homeLabel = new JLabel("Welcome to the Home Page!");
        panel.add(homeLabel);
        return panel;
    }

    private JPanel createServicesPanel() {
        JPanel panel = new JPanel();
        panel.setBackground(Color.LIGHT_GRAY);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel servicesLabel = new JLabel("Services Information:");
        servicesLabel.setFont(new Font("Arial", Font.BOLD, 16));
        panel.add(servicesLabel);

        JLabel service1 = new JLabel("Service 1: Description of service 1.");
        JLabel service2 = new JLabel("Service 2: Description of service 2.");
        JLabel service3 = new JLabel("Service 3: Description of service 3.");

        panel.add(service1);
        panel.add(service2);
        panel.add(service3);

        return panel;
    }

    private JPanel createContactPanel() {
        JPanel panel = new JPanel();
        panel.setBackground(Color.LIGHT_GRAY);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel contactLabel = new JLabel("Contact Information:");
        contactLabel.setFont(new Font("Arial", Font.BOLD, 16));
        panel.add(contactLabel);

        JLabel contact1 = new JLabel("Phone: +123-456-7890");
        JLabel contact2 = new JLabel("Email: contact@cspsyco.com");
        JLabel contact3 = new JLabel("Address: 123 Main St, City, Country");

        panel.add(contact1);
        panel.add(contact2);
        panel.add(contact3);

        return panel;
    }

    private JPanel createAboutPanel() {
        JPanel panel = new JPanel();
        panel.setBackground(Color.LIGHT_GRAY);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel aboutLabel = new JLabel("About Us:");
        aboutLabel.setFont(new Font("Arial", Font.BOLD, 16));
        panel.add(aboutLabel);

        JLabel about1 = new JLabel("C S Psyco is a company that provides...");
        JLabel about2 = new JLabel("We specialize in...");
        JLabel about3 = new JLabel("Our mission is...");

        panel.add(about1);
        panel.add(about2);
        panel.add(about3);

        return panel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }
}
