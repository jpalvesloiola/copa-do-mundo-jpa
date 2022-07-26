# copa-do-mundo-jpa
CRUD de jogadores, seleções e hotéis utilizando JSF e JPA

João Pedro A. Loiola
Experiência Projeto Copa do Mundo
Tenho experiência em alguns projetos acadêmicos, com fins de aprendizado. Um
deles que gostei de praticar foi o da Copa do Mundo, um sistema Web que gerencia hotel,
seleção e jogador na copa do mundo. Ou seja, o objetivo do sistema era ter um controle de
todos os jogadores inscritos na copa do mundo através de sua seleção e hotel de
hospedagem. O sistema deveria permitir um CRUD de jogador, hotel e seleção. O intuito
principal era exercitar as possíveis formas ou relacionamentos 1 : 1, N : N ou 1 : N utilizando
JPA, assim como o banco de dados.
Para iniciar o projeto criou-se um banco ”copa” com tabelas selecao, jogador, hotel
selcaoHotel(N : N) utilizando o MySQL. Definiu- se as classes do sistema: Selecao, Jogador
e Hotel na camada Model. Na camada Controller utilizou-se o Data Access Object (DAO) de
cada entidade para encapsular o acesso ao banco, ManagedBeans para “delegar” funções
específicas para cada View(JSF) na da aplicação, ConnectionFactory, enumeradores e
conversores. Para a camada View, utilizou-se 7 páginas xhtml(JSF com PrimeFaces e seus
temas) para exibir os dados de cada página específica. As seguintes página foram criadas
para permitir o CRUD de cada entidade do modelo de negócio: selecaoList.xhmtl,
selecaoForm.xhmtl, hotelList.xhmtl, hotelForm.xhmtl, jogadorList.xhmtl, jogadorForm.xhmtl e
index.xhmtl.
Neste projeto, pude tirar bom proveito do que aprendi sobre Java EE, arquitetura
MVC, JPA e Banco de Dados(MySQL). Através deste estudo pude colocar na prática a
construção de views em XHTML utilizando componentes do JSF e a Expression Language.
Isso me proporcionou maior conhecimento sobre o ciclo de vida das Servlets que são
instanciadas pelo container Apache Tomcat. Além disso, pude utilizar um Managed Bean
responsável por intermediar a comunicação dessas views com as demais camadas da
aplicação e o Data Access Object (DAO).
