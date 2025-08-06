package Calculadora;

import Geometrica.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

import Calculo.Soma;

public class Calculadora extends JFrame {

    private JButton btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0;
    private JButton btnponto, btnigua, btnsoma, btnmult, btnsubt, btndivi, btnac, btndel, btnGeometria, btnnegativo;
    private JButton btnPotencia, btnRaiz, btnLogaritmo; 
    private JTextField visor;
    private String operador = "";
    private float valor1 = 0, valor2 = 0;
    private boolean erroDivisaoPorZero = false;
    private boolean bloqueado = false;
	private Soma Somar;

    public Calculadora() {
        setTitle("Calculadora");
        setSize(400, 600);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        visor = new JTextField();
        visor.setFont(new Font("Tahoma", Font.PLAIN, 24));
        visor.setEditable(false);
        visor.setHorizontalAlignment(JTextField.RIGHT);
        visor.setPreferredSize(new Dimension(0, 70));
        add(visor, BorderLayout.NORTH);

        JPanel painel = new JPanel();
        painel.setLayout(new GridLayout(6, 4, 5, 5));
        painel.setBackground(Color.DARK_GRAY);

        btn1 = criarBotao("1", Color.WHITE);
        btn2 = criarBotao("2", Color.WHITE);
        btn3 = criarBotao("3", Color.WHITE);
        btn4 = criarBotao("4", Color.WHITE);
        btn5 = criarBotao("5", Color.WHITE);
        btn6 = criarBotao("6", Color.WHITE);
        btn7 = criarBotao("7", Color.WHITE);
        btn8 = criarBotao("8", Color.WHITE);
        btn9 = criarBotao("9", Color.WHITE);
        btn0 = criarBotao("0", Color.WHITE);
        btnponto = criarBotao(".", Color.WHITE);
        btnigua = criarBotaoIgual("=");
        btnsoma = criarBotao("+", Color.BLACK);
        btnsoma.setForeground(Color.WHITE);
        
        btnsubt = criarBotao("-", Color.BLACK);
        btnsubt.setForeground(Color.WHITE);
        
        btnmult = criarBotao("x", Color.BLACK);
        btnmult.setForeground(Color.WHITE);
        
        btndivi = criarBotao("÷", Color.BLACK);
        btndivi.setForeground(Color.WHITE);
        
        btnac = criarBotao("AC", Color.BLACK);
        btnac.setForeground(Color.WHITE);
        
        btndel = criarBotao("DEL", Color.BLACK);
        btndel.setForeground(Color.WHITE);
        
        btnnegativo = criarBotaoNegativo("(-)");
        btnnegativo.setForeground(Color.WHITE);
        
        btnGeometria = criarBotao("Geometria", Color.BLACK);
        btnGeometria.setForeground(Color.WHITE);

        btnPotencia = criarBotao("^", Color.BLACK);
        btnPotencia.setForeground(Color.WHITE);
        
        btnRaiz = criarBotao("√", Color.BLACK);
        btnRaiz.setForeground(Color.WHITE);
        
        btnLogaritmo = criarBotao("log", Color.BLACK);
        btnLogaritmo.setForeground(Color.WHITE);
        
        btnGeometria.setFont(new Font("Tahoma", Font.BOLD, 16));
        btnGeometria.setForeground(Color.WHITE);
        btnGeometria.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
                selecionarFormaGeometrica();
            }
        });

        painel.add(btn7);
        painel.add(btn8);
        painel.add(btn9);
        painel.add(btndivi);

        painel.add(btn4);
        painel.add(btn5);
        painel.add(btn6);
        painel.add(btnmult);

        painel.add(btn1);
        painel.add(btn2);
        painel.add(btn3);
        painel.add(btnsubt);

        painel.add(btn0);
        painel.add(btnponto);
        painel.add(btnnegativo);
        painel.add(btnsoma);
        
        painel.add(btnPotencia);
        painel.add(btnRaiz);
        painel.add(btnLogaritmo);
        painel.add(btnac);

        painel.add(btndel);
        painel.add(btnGeometria);
        painel.add(btnigua);
        
        add(painel);
        setVisible(true);
    }

    private JButton criarBotao(String texto, Color cor) {
        JButton botao = new JButton(texto);
        botao.setFont(new Font("Tahoma", Font.BOLD, 16));
        botao.setBackground(cor);
        botao.setForeground(Color.BLACK);
        botao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (bloqueado && !e.getActionCommand().equals("AC")) {
                    return;
                }

                String comando = e.getActionCommand();

                if ("0123456789.".contains(comando)) {
                    if (comando.equals(".") && visor.getText().contains(".")) {
                        return;
                    }
                    visor.setText(visor.getText() + comando);
                } else if ("+-x÷^√log".contains(comando)) {
                    if (!visor.getText().isEmpty()) {
                        valor1 = Float.parseFloat(visor.getText());
                        operador = comando;
                        visor.setText("");
                    }
                } else if (comando.equals("=")) {
                    if (!visor.getText().isEmpty()) {
                        valor2 = Float.parseFloat(visor.getText());
                        float resultado = calcular(valor1, valor2, operador);
                        visor.setText(String.valueOf(resultado));
                    }
                } else if (comando.equals("AC")) {
                    visor.setText("");
                    valor1 = valor2 = 0;
                    erroDivisaoPorZero = false;
                    bloqueado = false;
                } else if (comando.equals("DEL")) {
                    String atual = visor.getText();
                    if (atual.length() > 0) {
                        visor.setText(atual.substring(0, atual.length() - 1));
                    }
                }
            }
        });
        return botao;
    }

    private JButton criarBotaoIgual(String texto) {
        JButton botao = new JButton(texto);
        botao.setFont(new Font("Tahoma", Font.BOLD, 16));
        botao.setBackground(Color.RED);
        botao.setForeground(Color.WHITE);
        botao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!visor.getText().isEmpty()) {
                    valor2 = Float.parseFloat(visor.getText());
                    float resultado = calcular(valor1, valor2, operador);
                    visor.setText(String.valueOf(resultado));
                }
            }
        });
        return botao;
    }

    private JButton criarBotaoNegativo(String texto) {
        JButton botao = new JButton(texto);
        botao.setFont(new Font("Tahoma", Font.BOLD, 16));
        botao.setBackground(Color.BLACK);
        botao.setForeground(Color.WHITE);
        botao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String atual = visor.getText();
                if (atual.length() > 0) {
                    if (atual.startsWith("-")) {
                        visor.setText(atual.substring(1));
                    } else {
                        visor.setText("-" + atual);
                    }
                }
            }
        });
        return botao;
    }

    private float calcular(float valor1, float valor2, String operador) {
        try {
            switch (operador) {
                case "+":
                	Soma sm = new Soma();
                	sm.Somar(valor1, valor2); 
                    float resultado = sm.getResultado(); 
                    System.out.println("Resultado da soma: " + resultado); 

                case "-":
                    return valor1 - valor2;
                case "x":
                    return valor1 * valor2;
                case "÷":
                    if (valor2 == 0) {
                        throw new ArithmeticException("Divisão por zero");
                    }
                    return valor1 / valor2;
                case "^":
                    return (float) Math.pow(valor1, valor2);
                case "√":
                    return (float) Math.sqrt(valor1); 
                case "log":
                    return (float) Math.log(valor1); 
                default:
                    return 0;
            }
        } catch (ArithmeticException e) {
            visor.setText("Erro");
            erroDivisaoPorZero = true;
            return 0;
        }
    }

    private void selecionarFormaGeometrica() {
        String[] opcoes = {"Quadrado", "Retângulo", "Trapézio", "Triângulo", "Losango"};
        String escolha = (String) JOptionPane.showInputDialog(
                this, "Escolha a forma geométrica:", "Cálculo de Área",
                JOptionPane.PLAIN_MESSAGE,
                null, opcoes, opcoes[0]
        );

        if (escolha != null) {
            switch (escolha) {
                case "Quadrado":
                    calcularAreaQuadrado();
                    break;
                case "Retângulo":
                    calcularAreaRetangulo();
                    break;
                case "Trapézio":
                    calcularAreaTrapezio();
                    break;
                case "Triângulo":
                    calcularAreaTriangulo();
                    break;
                case "Losango":
                    calcularAreaLosango();
                    break;
            }
        }
    }

    private void calcularAreaQuadrado() {
        try {
            float lado = Float.parseFloat(JOptionPane.showInputDialog("Informe o lado do quadrado:"));
            Quadrado quadrado = new Quadrado();
            quadrado.AreaQ(lado);
            visor.setText("Área do Quadrado: " + quadrado.getResultado());
            bloquearVisor();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Por favor, insira um valor válido.");
        }
    }

    private void calcularAreaRetangulo() {
        try {
            float base = Float.parseFloat(JOptionPane.showInputDialog("Informe a base do retângulo:"));
            float altura = Float.parseFloat(JOptionPane.showInputDialog("Informe a altura do retângulo:"));
            Retangulo retangulo = new Retangulo();
            retangulo.AreaR(base, altura);
            visor.setText("Área do Retângulo: " + retangulo.getResultado());
            bloquearVisor();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Por favor, insira um valor válido.");
        }
    }

    private void calcularAreaTrapezio() {
        try {
            float baseMaior = Float.parseFloat(JOptionPane.showInputDialog("Informe a base maior do trapézio:"));
            float baseMenor = Float.parseFloat(JOptionPane.showInputDialog("Informe a base menor do trapézio:"));
            float altura = Float.parseFloat(JOptionPane.showInputDialog("Informe a altura do trapézio:"));
            Trapezio trapezio = new Trapezio();
            trapezio.AreaTra(baseMaior, baseMenor, altura);
            visor.setText("Área do Trapézio: " + trapezio.getResultado());
            bloquearVisor();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Por favor, insira um valor válido.");
        }
    }

    private void calcularAreaTriangulo() {
        try {
            float base = Float.parseFloat(JOptionPane.showInputDialog("Informe a base do triângulo:"));
            float altura = Float.parseFloat(JOptionPane.showInputDialog("Informe a altura do triângulo:"));
            Triangulo triangulo = new Triangulo();
            triangulo.AreaT(base, altura);
            visor.setText("Área do Triângulo: " + triangulo.getResultado());
            bloquearVisor();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Por favor, insira um valor válido.");
        }
    }

    private void calcularAreaLosango() {
        try {
            float diagonalMaior = Float.parseFloat(JOptionPane.showInputDialog("Informe a diagonal maior do losango:"));
            float diagonalMenor = Float.parseFloat(JOptionPane.showInputDialog("Informe a diagonal menor do losango:"));
            Losango losango = new Losango();
            losango.AreaL(diagonalMaior, diagonalMenor);
            visor.setText("Área do Losango: " + losango.getResultado());
            bloquearVisor();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Por favor, insira um valor válido.");
        }
    }

    private void bloquearVisor() {
        bloqueado = true;
    }

    public static void main(String[] args) {
        new Calculadora();
    }
}
