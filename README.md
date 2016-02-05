Simple JSP (JAVA) pagination
=============

Simple java class for paginating JSP using Bootstrap 3.


Installation
-----------

    Add SimpleJspPagination.jar in your Bootstrap 3 jsp project.

Usage
-----

More information see a example in this git.


	<%

	  SimpleJspPagination paginacao = new SimpleJspPagination();

	  paginacao.setTotalRegistros(100); // Informar o total de registros de todos os dados que queira exibir

	  paginacao.setTotalPorPagina(5); // Total de registros por página (Não obrigatorio)

	  paginacao.setClassesCSS("pagination-sm"); // Coloca uma classe de estilo css dentro da ul (Não obrigatorio)

	  paginacao.setUrl("index.jsp"); // Nome da página



	  // Se não tiver a pagina no get seta 1 para pagina

	  String paginaAtual = "1";

	  if (request.getParameter("pagina") != null) {

		  paginaAtual = request.getParameter("pagina");

	  }



	  paginacao.setPaginaAtual(paginaAtual);
	  out.write(paginacao.paginacaoNumerica());
	  // Or
	  out.write(paginacao.paginacaoProximaAnterior());
	%>
	
	
Imagem
-----	
![Example](http://oi60.tinypic.com/25u094g.jpg "Example")
