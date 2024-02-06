package Main;

import DBConnection.DBConnection;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameHistory {
    public List<Map<String, Object>> retrieveGameData() {
        Connection dbconn = DBConnection.connectDB();
        List<Map<String, Object>> gameDataList = new ArrayList<>();

        if (dbconn != null) {
            try {
                PreparedStatement st = dbconn.prepareStatement(
                        "SELECT gh.*, gd.* " +
                                "FROM gamehistory AS gh " +
                                "INNER JOIN gamedata AS gd ON gh.id = gd.game_history_id");

                ResultSet resultSet = st.executeQuery();

                while (resultSet.next()) {
                    // Retrieve data from the result set and store it in a HashMap
                    Map<String, Object> gameData = new HashMap<>();
                    gameData.put("gameId", resultSet.getInt("gh.id"));
                    gameData.put("player1Name", resultSet.getString("gh.player1_name"));
                    gameData.put("player2Name", resultSet.getString("gh.player2_name"));
                    gameData.put("player1GameStatus", resultSet.getString("gh.player1_gamestatus"));
                    gameData.put("player2GameStatus", resultSet.getString("gh.player2_gamestatus"));
                    gameData.put("gameDataId", resultSet.getInt("gd.id"));
                    gameData.put("gameHistoryId", resultSet.getInt("gd.game_history_id"));
                    gameData.put("startedAt", resultSet.getString("gd.started_at"));
                    gameData.put("endedAt", resultSet.getString("gd.ended_at"));

                    // Add the HashMap to the list
                    gameDataList.add(gameData);

                }

                resultSet.close();
            } catch (Exception ex) {
                System.out.println(ex);
            } finally {
                try {
                    dbconn.close();
                } catch (SQLException ex) {
                    System.out.println("Error closing database connection: " + ex.getMessage());
                }
            }
        } else {
            System.out.println("Database connection is not established");
        }

        return gameDataList;
    }

    public GameHistory() throws Exception {

        JFrame frame = new JFrame("Game History");
        frame.setSize(1000, 700);
        // frame.setUndecorated(true);

        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                GameMenu menu = new GameMenu();
                menu.GameMenu();
                frame.dispose();
            }
        });

        frame.setLocationRelativeTo(null);
        JPanel mainPanel = new JPanel(new BorderLayout());

        JLabel label = new JLabel("Game History");
        label.setFont(new Font("Arial", Font.BOLD, 20));
        label.setHorizontalAlignment(JLabel.CENTER);
        int labelTopPadding = 15;
        int labelBottomPadding = 15;
        int labelLeftPadding = 0;
        int labelRightPadding = 0;
        label.setBorder(BorderFactory.createEmptyBorder(labelTopPadding, labelLeftPadding, labelBottomPadding,
                labelRightPadding));
        mainPanel.add(label, BorderLayout.NORTH);

        DefaultTableModel model = new DefaultTableModel();

        List<Map<String, Object>> gameDataList = retrieveGameData();
        model.addColumn("Game ID");
        model.addColumn("PlayerName");
        model.addColumn("Game Status");
        model.addColumn("Started At");
        model.addColumn("Ended At");

        if (gameDataList.isEmpty()) {
            model.addRow(new Object[] { "", "", "Empty Game History", "", "" });

        } else {
            for (Map<String, Object> gameData : gameDataList) {
                String player1Name = (String) gameData.get("player1Name");
                String player2Name = (String) gameData.get("player2Name");
                String player1GameStatus = (String) gameData.get("player1GameStatus");
                String player2GameStatus = (String) gameData.get("player2GameStatus");
                int gameDataId = (int) gameData.get("gameDataId");
                String startedAt = (String) gameData.get("startedAt");
                String endedAt = (String) gameData.get("endedAt");

                model.addRow(new Object[] { gameDataId, player1Name, player1GameStatus, startedAt, endedAt });
                model.addRow(new Object[] { gameDataId, player2Name, player2GameStatus, startedAt, endedAt });
                model.addRow(new Object[] { "" });
            }
        }

        JTable table = new JTable(model) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

            @Override
            public void paintComponent(Graphics g) {
                g.setColor(new Color(240, 240, 240));
                g.fillRect(0, 0, getWidth(), getHeight());
                super.paintComponent(g);
            }

            @Override
            public void setGridColor(Color gridColor) {
                super.setGridColor(Color.WHITE);
            }

            @Override
            public void setShowGrid(boolean showGrid) {
                super.setShowGrid(false);
            }
        };
        int gameIdColumnIndex = 0;
        int preferredWidth = 30;
        table.getColumnModel().getColumn(gameIdColumnIndex).setPreferredWidth(preferredWidth);
        table.setFont(new Font("Arial", Font.PLAIN, 14));
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.setRowHeight(30);
        table.setShowHorizontalLines(false);
        table.setShowVerticalLines(false);

        JTableHeader header = table.getTableHeader();
        header.setFont(new Font("Arial", Font.BOLD, 14));
        header.setBackground(Color.DARK_GRAY);
        header.setForeground(Color.WHITE);

        table.setSelectionBackground(new Color(72, 121, 186));
        table.setSelectionForeground(Color.WHITE);

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int selectedRow = table.getSelectedRow();

            }
        });

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBorder(null);

        scrollPane.getViewport().setBorder(null);
        scrollPane.getViewport().setOpaque(false);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        frame.getContentPane().add(mainPanel);

        frame.setVisible(true);
    }

}
