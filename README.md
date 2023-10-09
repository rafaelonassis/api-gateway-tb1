# api-gateway-tb1

API construída para tarefa de APi Gateway & Integration, foi implementado paginação e conexão no Postgree SQL e algumas valisações que podem ser testadas.
Tenha o app PosgreeSQL para rodar a aplicação, no arquivo "application.properties" as congigurações foram realizadas. Estou fazendo a gestão do banco através do app "pgAdmin 4".
Crie um DB com o nome descrito no "application.properties" = impacta-api
Configure seu usuario e senha no "application.properties", caso não tenha usuario e senha, poderá cria-los no banco conforme esta no arquivo "application.properties".

Tenha a versão do java 11 rodando em sua maquina e o maven para que não tenha problemas ao rodar a API, após isso, pode rodar a aplicação spring na classe "ApiGatewayTb1Application".

Obs: o arquivo "thunder-collection_impacta-api-tb1.json" contém a collection utilizada, os itens que estão comentados nos endpoints de POST foram inseridos para facilitar na inserção de mais de um item e as consultas sejam visualizadas de uma forma melhor.
