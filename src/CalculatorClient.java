import java.rmi.Naming;

import javax.swing.JOptionPane;

public class CalculatorClient {
	public static void main(String[] args) {
		try {
			String opcao[] = { "+", "-", "*", "/" };

			Calculator c = (Calculator) Naming.lookup("//localhost:8080/CalculatorService");

			int a = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o primeiro valor: "));

			int operacao = JOptionPane.showOptionDialog(null, "Escolha uma das operações", "Tipo de operação", 0,
					JOptionPane.INFORMATION_MESSAGE, null, opcao, opcao[0]);

			int b = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o segundo valor: "));

			switch (opcao[operacao]) {
			case "+":
				JOptionPane.showMessageDialog(null, "Resultado: "  + c.add(a, b));
				System.out.println(c.add(a, b));
				break;
			case "-":
				JOptionPane.showMessageDialog(null, "Resultado: "  + c.sub(a, b));
				System.out.println(c.sub(a, b));

				break;
			case "*":
				JOptionPane.showMessageDialog(null, "Resultado: "  + c.mul(a, b));
				System.out.println(c.mul(a, b));

				break;
			case "/":
				JOptionPane.showMessageDialog(null, "Resultado: "  + c.div(a, b));
				System.out.println(c.div(a, b));

			default:
				break;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
