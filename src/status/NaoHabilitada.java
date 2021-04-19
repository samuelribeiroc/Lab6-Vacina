package status;

import governo.Pessoa;

public class NaoHabilitada implements Status{
    public void atualiza(Pessoa pessoa) {
        pessoa.setStatus(new HabilitadaPrimeiraDose());
    }

    public String toString() {
        return "Nao habilitada para vacina.";
    }
}
