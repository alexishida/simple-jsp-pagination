<%@page import="com.alexishida.simplejsppagination.SimpleJspPagination"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%

    SimpleJspPagination paginacao = new SimpleJspPagination();
    paginacao.setTotalRegistros(100); // Informar o total de registros de todos os dados que queira exibir
    paginacao.setTotalPorPagina(5); // Total de registros por página (Não obrigatorio)
    paginacao.setClassesCSS("pagination-sm"); // coloca uma classe de estilo dentro da ul (Não obrigatorio)
    paginacao.setUrl("index.jsp");

    // Se não tiver a pagina no get seta 1 para pagina
    String paginaAtual = "1";
    if (request.getParameter("pagina") != null) {
        paginaAtual = request.getParameter("pagina");
    }

    paginacao.setPaginaAtual(paginaAtual);
%>   
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SimpleJspPagination Exemplos</title>
        <!-- Bootstrap core CSS -->
        <link href="css/bootstrap.min.css" rel="stylesheet">

    </head>
    <body>
        <div class="container">
            <h2 class="page-header">Simples Paginação JSP</h2>  
            <p>Criado por <a href="mailto:alexishida@gmail.com">Alex Ishida</a>, mais informações <a href="https://github.com/alexishida/simple-jsp-pagination">https://github.com/alexishida/simple-jsp-pagination</a>.</p>
            
            
            
            <h2 class="page-header">Exemplo 1 - Paginação Numérica</h2>

            <div class="highlight">
                <pre>
                      <code class="html">
                          <span>
                              &lt;%<br />
                              &nbsp;&nbsp;&nbsp; SimpleJspPagination paginacao = new SimpleJspPagination();<br />
                              &nbsp;&nbsp;&nbsp; paginacao.setTotalRegistros(100); // Informar o total de registros de todos os dados que queira exibir<br />
                              &nbsp;&nbsp;&nbsp; paginacao.setTotalPorPagina(5); // Total de registros por p&aacute;gina (N&atilde;o obrigatorio)<br />
                              &nbsp;&nbsp;&nbsp; paginacao.setClassesCSS(&quot;pagination-sm&quot;); // Coloca uma classe de estilo css dentro da ul (N&atilde;o obrigatorio)<br />
                              &nbsp;&nbsp;&nbsp; paginacao.setUrl(&quot;index.jsp&quot;); // Nome da p&aacute;gina<br />
                              <br />
                              &nbsp;&nbsp;&nbsp; // Se n&atilde;o tiver a pagina no get seta 1 para pagina<br />
                              &nbsp;&nbsp;&nbsp; String paginaAtual = &quot;1&quot;;<br />
                              &nbsp;&nbsp;&nbsp; if (request.getParameter(&quot;pagina&quot;) != null) {<br />
                              &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; paginaAtual = request.getParameter(&quot;pagina&quot;);<br />
                              &nbsp;&nbsp;&nbsp; }<br />
                              <br />
                              &nbsp;&nbsp;&nbsp; paginacao.setPaginaAtual(paginaAtual);
                              &nbsp;&nbsp;&nbsp; out.write(paginacao.paginacaoNumerica());<br />
                              %&gt;&nbsp;</span>

                      </code>
                  </pre>
            </div>

            <%  out.write(paginacao.paginacaoNumerica()); %>
            
            <br/>
            
            <h2 class="page-header">Exemplo 1 - Paginação Próximo e Anterior</h2>
            <div class="highlight">
                <pre>
                      <code class="html">
                          <span>
                            
	&lt;%<br />
	&nbsp;&nbsp;&nbsp; SimpleJspPagination paginacao = new SimpleJspPagination();<br />
	&nbsp;&nbsp;&nbsp; paginacao.setTotalRegistros(100); // Informar o total de registros de todos os dados que queira exibir<br />
	&nbsp;&nbsp;&nbsp; paginacao.setTotalPorPagina(5); // Total de registros por p&aacute;gina (N&atilde;o obrigatorio)<br />
	&nbsp;&nbsp;&nbsp; paginacao.setClassesCSS(&quot;pagination-sm&quot;); // Coloca uma classe de estilo css dentro da ul (N&atilde;o obrigatorio)<br />
	&nbsp;&nbsp;&nbsp; paginacao.setUrl(&quot;index.jsp&quot;); // Nome da p&aacute;gina<br />
	<br />
	&nbsp;&nbsp;&nbsp; // Se n&atilde;o tiver a pagina no get seta 1 para pagina<br />
	&nbsp;&nbsp;&nbsp; String paginaAtual = &quot;1&quot;;<br />
	&nbsp;&nbsp;&nbsp; if (request.getParameter(&quot;pagina&quot;) != null) {<br />
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; paginaAtual = request.getParameter(&quot;pagina&quot;);<br />
	&nbsp;&nbsp;&nbsp; }<br />
	<br />
	&nbsp;&nbsp;&nbsp; paginacao.setPaginaAtual(paginaAtual);
	&nbsp;&nbsp;&nbsp; out.write(paginacao.paginacaoProximaAnterior());<br />
	%&gt;&nbsp;


                      </code>
                  </pre>
            </div>
            <%  out.write(paginacao.paginacaoProximaAnterior());%>
        </div>
        <!-- Bootstrap Javascript -->
        <script src="js/jquery.js"></script>
        <script src="js/bootstrap.min.js"></script>

    </body>
</html>
