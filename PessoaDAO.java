import java.util.ArrayList;
import java.util.List;

class PessoaDAO {
    private List<Pessoa> pessoas = new ArrayList<>();

    public void adicionarPessoa(Pessoa pessoa) {
        pessoas.add(pessoa);
    }

    public List<Pessoa> listarPessoas() {
        return pessoas;
    }

    public void atualizarPessoa(int indice, Pessoa pessoa) {
        if (indice >= 0 && indice < pessoas.size()) {
            pessoas.set(indice, pessoa);
        }
    }

    public void removerPessoa(int indice) {
        if (indice >= 0 && indice < pessoas.size()) {
            pessoas.remove(indice);
        }
    }
}