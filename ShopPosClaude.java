import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class ShopPosClaude extends JFrame {

    // Product prices
    private static final double SUGAR_PRICE = 150.0;
    private static final double TEA_PRICE = 50.0;
    private static final double RICE_PRICE = 100.0;
    private static final double UNGA_PRICE = 140.0;

    // Quantity fields
    private JTextField sugarQtyField, teaQtyField, riceQtyField, ungaQtyField;

    // Total fields
    private JTextField sugarTotalField, teaTotalField, riceTotalField, ungaTotalField;

    // Summary fields
    private JTextField totalPriceField, cashReceivedField, changeField;

    // Colors
    private static final Color BG_COLOR        = new Color(245, 245, 250);
    private static final Color PANEL_COLOR      = new Color(255, 255, 255);
    private static final Color HEADER_COLOR     = new Color(30, 60, 114);
    private static final Color HEADER_TEXT      = Color.WHITE;
    private static final Color ROW_ALT_COLOR    = new Color(235, 240, 255);
    private static final Color ACCENT_COLOR     = new Color(30, 60, 114);
    private static final Color BORDER_COLOR     = new Color(200, 210, 230);
    private static final Color INPUT_BG         = new Color(250, 252, 255);
    private static final Color READONLY_BG      = new Color(240, 245, 255);
    private static final Color BTN1_COLOR       = new Color(30, 60, 114);
    private static final Color BTN2_COLOR       = new Color(22, 130, 100);

    public ShopPosClaude() {
        setTitle("Shop POS");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(700, 560));
        setSize(800, 620);
        setLocationRelativeTo(null);

        // Main panel with border layout so it fills the frame
        JPanel mainPanel = new JPanel(new BorderLayout(0, 0));
        mainPanel.setBackground(BG_COLOR);
        mainPanel.setBorder(new EmptyBorder(20, 24, 20, 24));

        // ── Title bar ──────────────────────────────────────────────
        JLabel titleLabel = new JLabel("  🛒  Shop Point of Sale", SwingConstants.LEFT);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));
        titleLabel.setForeground(ACCENT_COLOR);
        titleLabel.setBorder(new EmptyBorder(0, 0, 14, 0));
        mainPanel.add(titleLabel, BorderLayout.NORTH);

        // ── Center: product table + summary ───────────────────────
        JPanel centerPanel = new JPanel(new BorderLayout(0, 16));
        centerPanel.setOpaque(false);

        centerPanel.add(buildProductTable(), BorderLayout.CENTER);
        centerPanel.add(buildSummaryPanel(), BorderLayout.SOUTH);

        mainPanel.add(centerPanel, BorderLayout.CENTER);

        // ── Bottom: buttons ────────────────────────────────────────
        mainPanel.add(buildButtonPanel(), BorderLayout.SOUTH);

        setContentPane(mainPanel);
    }

    // ── Product table ──────────────────────────────────────────────────────────
    private JPanel buildProductTable() {
        JPanel wrapper = new JPanel(new BorderLayout());
        wrapper.setBackground(PANEL_COLOR);
        wrapper.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(BORDER_COLOR, 1, true),
                new EmptyBorder(0, 0, 0, 0)));

        // Header row
        wrapper.add(buildHeaderRow(), BorderLayout.NORTH);

        // Product rows
        JPanel rows = new JPanel(new GridLayout(4, 1, 0, 0));
        rows.setBackground(PANEL_COLOR);

        String[] names  = {"Sugar",    "Tea Leaves", "Rice",      "Unga"};
        String[] prices = {"sh.150/kg","sh.50/pkt",  "sh.100/kg", "sh.140/kg"};

        sugarQtyField = makeQtyField();
        teaQtyField   = makeQtyField();
        riceQtyField  = makeQtyField();
        ungaQtyField  = makeQtyField();

        sugarTotalField = makeTotalField();
        teaTotalField   = makeTotalField();
        riceTotalField  = makeTotalField();
        ungaTotalField  = makeTotalField();

        JTextField[] qtyFields   = {sugarQtyField, teaQtyField, riceQtyField, ungaQtyField};
        JTextField[] totalFields = {sugarTotalField, teaTotalField, riceTotalField, ungaTotalField};

        for (int i = 0; i < 4; i++) {
            Color bg = (i % 2 == 0) ? PANEL_COLOR : ROW_ALT_COLOR;
            rows.add(buildProductRow(names[i], prices[i], qtyFields[i], totalFields[i], bg));
        }

        wrapper.add(rows, BorderLayout.CENTER);
        return wrapper;
    }

    private JPanel buildHeaderRow() {
        JPanel header = new JPanel(new GridLayout(1, 4, 0, 0));
        header.setBackground(HEADER_COLOR);
        header.setBorder(new EmptyBorder(10, 14, 10, 14));

        String[] cols = {"PRODUCTS", "PRICE", "QUANTITY", "TOTAL"};
        for (String col : cols) {
            JLabel lbl = new JLabel(col);
            lbl.setFont(new Font("Segoe UI", Font.BOLD, 13));
            lbl.setForeground(HEADER_TEXT);
            header.add(lbl);
        }
        return header;
    }

    private JPanel buildProductRow(String name, String price,
                                   JTextField qtyField, JTextField totalField,
                                   Color bg) {
        JPanel row = new JPanel(new GridLayout(1, 4, 0, 0));
        row.setBackground(bg);
        row.setBorder(new EmptyBorder(8, 14, 8, 14));

        JLabel nameLbl = new JLabel(name);
        nameLbl.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        nameLbl.setForeground(new Color(40, 40, 60));

        JLabel priceLbl = new JLabel(price);
        priceLbl.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        priceLbl.setForeground(new Color(60, 100, 60));

        row.add(nameLbl);
        row.add(priceLbl);
        row.add(wrapField(qtyField));
        row.add(wrapField(totalField));
        return row;
    }

    // ── Summary panel ──────────────────────────────────────────────────────────
    private JPanel buildSummaryPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(PANEL_COLOR);
        panel.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(BORDER_COLOR, 1, true),
                new EmptyBorder(10, 14, 10, 14)));

        GridBagConstraints lc = new GridBagConstraints();
        lc.anchor = GridBagConstraints.WEST;
        lc.insets = new Insets(6, 4, 6, 10);

        GridBagConstraints fc = new GridBagConstraints();
        fc.fill    = GridBagConstraints.HORIZONTAL;
        fc.weightx = 1.0;
        fc.insets  = new Insets(6, 0, 6, 4);

        totalPriceField   = makeSummaryField(false);
        cashReceivedField = makeSummaryField(true);
        changeField       = makeSummaryField(false);

        String[] labels = {"Total Price", "Cash Received", "Change"};
        JTextField[] fields = {totalPriceField, cashReceivedField, changeField};

        for (int i = 0; i < 3; i++) {
            lc.gridx = 0; lc.gridy = i;
            JLabel lbl = new JLabel(labels[i]);
            lbl.setFont(new Font("Segoe UI", Font.BOLD, 13));
            lbl.setForeground(new Color(40, 40, 80));
            panel.add(lbl, lc);

            fc.gridx = 1; fc.gridy = i;
            panel.add(fields[i], fc);
        }

        return panel;
    }

    // ── Button panel ───────────────────────────────────────────────────────────
    private JPanel buildButtonPanel() {
        JPanel panel = new JPanel(new GridLayout(1, 2, 14, 0));
        panel.setOpaque(false);
        panel.setBorder(new EmptyBorder(16, 0, 0, 0));

        JButton calcTotalBtn   = makeButton("Calculate Total",   BTN1_COLOR);
        JButton calcBalanceBtn = makeButton("Calculate Balance", BTN2_COLOR);

        calcTotalBtn.addActionListener(e -> calculateTotal());
        calcBalanceBtn.addActionListener(e -> calculateBalance());

        panel.add(calcTotalBtn);
        panel.add(calcBalanceBtn);
        return panel;
    }

    // ── Field factories ────────────────────────────────────────────────────────
    private JTextField makeQtyField() {
        JTextField f = new JTextField("0");
        f.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        f.setBackground(INPUT_BG);
        f.setForeground(new Color(30, 30, 60));
        f.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(BORDER_COLOR, 1, true),
                new EmptyBorder(3, 6, 3, 6)));
        f.setHorizontalAlignment(SwingConstants.RIGHT);
        return f;
    }

    private JTextField makeTotalField() {
        JTextField f = new JTextField();
        f.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        f.setBackground(READONLY_BG);
        f.setForeground(new Color(30, 90, 30));
        f.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(BORDER_COLOR, 1, true),
                new EmptyBorder(3, 6, 3, 6)));
        f.setEditable(false);
        f.setHorizontalAlignment(SwingConstants.RIGHT);
        return f;
    }

    private JTextField makeSummaryField(boolean editable) {
        JTextField f = new JTextField(editable ? "0" : "");
        f.setFont(new Font("Segoe UI", Font.BOLD, 13));
        f.setBackground(editable ? INPUT_BG : READONLY_BG);
        f.setForeground(new Color(30, 30, 80));
        f.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(BORDER_COLOR, 1, true),
                new EmptyBorder(4, 8, 4, 8)));
        f.setEditable(editable);
        f.setHorizontalAlignment(SwingConstants.RIGHT);
        return f;
    }

    private JPanel wrapField(JTextField f) {
        JPanel p = new JPanel(new BorderLayout());
        p.setOpaque(false);
        p.setBorder(new EmptyBorder(2, 4, 2, 4));
        p.add(f, BorderLayout.CENTER);
        return p;
    }

    private JButton makeButton(String text, Color bg) {
        JButton btn = new JButton(text) {
            @Override protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                                    RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(getModel().isPressed() ? bg.darker()
                            : getModel().isRollover() ? bg.brighter() : bg);
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 10, 10);
                g2.dispose();
                super.paintComponent(g);
            }
        };
        btn.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btn.setForeground(Color.WHITE);
        btn.setBackground(bg);
        btn.setFocusPainted(false);
        btn.setBorderPainted(false);
        btn.setContentAreaFilled(false);
        btn.setOpaque(false);
        btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btn.setPreferredSize(new Dimension(0, 42));
        return btn;
    }

    // ── Business logic ─────────────────────────────────────────────────────────
    private void calculateTotal() {
        try {
            double sugarQty = parseQty(sugarQtyField);
            double teaQty   = parseQty(teaQtyField);
            double riceQty  = parseQty(riceQtyField);
            double ungaQty  = parseQty(ungaQtyField);

            double sugarTotal = sugarQty * SUGAR_PRICE;
            double teaTotal   = teaQty   * TEA_PRICE;
            double riceTotal  = riceQty  * RICE_PRICE;
            double ungaTotal  = ungaQty  * UNGA_PRICE;

            sugarTotalField.setText(String.format("%.2f", sugarTotal));
            teaTotalField  .setText(String.format("%.2f", teaTotal));
            riceTotalField .setText(String.format("%.2f", riceTotal));
            ungaTotalField .setText(String.format("%.2f", ungaTotal));

            double grand = sugarTotal + teaTotal + riceTotal + ungaTotal;
            totalPriceField.setText(String.format("sh. %.2f", grand));
            changeField.setText("");  // reset change when total recalculated

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                    "Please enter valid numbers in quantity fields.",
                    "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void calculateBalance() {
        try {
            String totalText = totalPriceField.getText().replace("sh.", "").trim();
            if (totalText.isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "Please calculate the total first.",
                        "No Total", JOptionPane.WARNING_MESSAGE);
                return;
            }
            double total    = Double.parseDouble(totalText);
            double cash     = Double.parseDouble(cashReceivedField.getText().trim());
            double change   = cash - total;

            if (change < 0) {
                changeField.setForeground(new Color(180, 30, 30));
                changeField.setText(String.format("sh. %.2f  (insufficient)", change));
            } else {
                changeField.setForeground(new Color(30, 100, 30));
                changeField.setText(String.format("sh. %.2f", change));
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                    "Please enter a valid cash amount.",
                    "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private double parseQty(JTextField f) {
        String t = f.getText().trim();
        return t.isEmpty() ? 0 : Double.parseDouble(t);
    }

    // ── Entry point ────────────────────────────────────────────────────────────
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ignored) {}

        SwingUtilities.invokeLater(() -> new ShopPosClaude().setVisible(true));
    }
}
