package gui;

import models.Song;

import javax.swing.*;

import client.JSocketClient;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;

public class MusicClientGUI extends JFrame {
    private JSocketClient client;
    private JComboBox<String> comboSearchType;
    private JTextField txtQuery;
    private JTextArea txtResults;

    public MusicClientGUI(String host, int port) {
        this.client = new JSocketClient(host, port);
        initUI();
    }

    private void initUI() {
        setTitle("Biblioteca de Música");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Panel de búsqueda
        JPanel panelSearch = new JPanel(new FlowLayout());
        comboSearchType = new JComboBox<>(new String[]{"title", "genre", "author"});
        txtQuery = new JTextField(20);
        JButton btnSearch = new JButton("Buscar");
        btnSearch.addActionListener(this::onSearchClicked);

        panelSearch.add(new JLabel("Buscar por:"));
        panelSearch.add(comboSearchType);
        panelSearch.add(txtQuery);
        panelSearch.add(btnSearch);

        // Área de resultados
        txtResults = new JTextArea();
        txtResults.setEditable(false);
        JScrollPane scroll = new JScrollPane(txtResults);

        // Layout principal
        setLayout(new BorderLayout());
        add(panelSearch, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);
    }

    private void onSearchClicked(ActionEvent e) {
        String type = (String) comboSearchType.getSelectedItem();
        String query = txtQuery.getText().trim();

        if (query.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese un término de búsqueda.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        List<Song> results = client.sendQuery(type, query);
        txtResults.setText("");

        if (results.isEmpty()) {
            txtResults.append("No se encontraron resultados.\n");
        } else {
            results.forEach(song -> txtResults.append(song.toString() + "\n"));
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MusicClientGUI("localhost", 1802).setVisible(true));
    }
}
