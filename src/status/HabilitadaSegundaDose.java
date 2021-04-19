package status;

import governo.Pessoa;

public class HabilitadaSegundaDose implements Status{
    public void atualiza(Pessoa pessoa) {
        pessoa.setStatus(new Vacinade());
    }

    public String toString() {
        return "Habilitada para tomar a segunda dose.";
    }
}
