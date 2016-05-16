package br.com.broker.configuration;

public enum DealBrokerRequests {
    ACAO_LISTA("http://localhost:8090/rest/acao/lista", ""),
    ACAO_ATUALIZAR_PRECO("http://localhost:8090/rest/acao/atualizar_preco", ""),
    CLIENTE_CADASTRAR("http://localhost:8090/rest/cliente/cadastrar", "{\"cpf\": \"%s\", \"password\": \"%s\"}"),
    CARTEIRA_CONSULTAR("http://localhost:8090/rest/carteira/consultar", ""),
    CARTEIRA_ADICIONAR("http://localhost:8090/rest/carteira/adicionar", ""),
    CARTEIRA_REMOVER("http://localhost:8090/rest/carteira/remober", ""),
    CONTA_CORRENTE_CONSULTAR_SALDO("http://localhost:8090/rest/conta_corrente/consultar_saldo", ""),
    CONTA_CORRENTE_CREDITAR("http://localhost:8090/rest/conta_corrente/creditar", ""),
    ORDEM_CONSULTAR_SALDO("http://localhost:8090/rest/ordem/consultar_saldo", ""),
    ORDEM_EMITIR("http://localhost:8090/rest/ordem/emitir", ""),
    RELATORIO_CONSULTAR("http://localhost:8090/rest/relatorio/consultar", "");

    private String url;
    private String json;

    DealBrokerRequests(final String url, final String json) {
	this.url = url;
	this.json = json;
    }

    public String getUrl() {
	return url;
    }

    public String getFormattedJson(Object... objects) {
	return String.format(json, objects);
    }
}
