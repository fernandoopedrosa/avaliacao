
<%@ include file="/WEB-INF/jsp/template/cabecalho.jsp" %> 
<body>
	<header>
		<div class="container">
			<h1 class="titulo">Lista de Ferramentas</h1>
		</div>
	</header>
	<main>
		<section class="container">	    
		    <p> ${sucesso}</p>
		    
		    <label for="filtrar-tabela">Filtro:</label>
		    <input type="text" name="filtro" id="filtrar-tabela" placeholder="Digite o título da ferramenta" size="23"></br></br>
		</section>
		
		<section class="container">	    
		    <table class="table table-bordered table-striped table-hover">
		        <tr>
		            <th>Título</th>
		            <th>Link</th>
		            <th>Descrição</th>
		            <th>Tags</th>
		            <th>Ação</th>
		        </tr>
		        <c:forEach items="${tools }" var="tool">
					<tr class="tool">
						<td class="info-title">${tool.title }</td>
						<td>${tool.link }</td>
						<td>${tool.description }</td>
						<td>
							<c:forEach items="${tool.tags}" var="tag">
								${ tag.name}
							</c:forEach>
						</td>
						<td>
							<button id="botaoRemover" class="btn btn-primary excluir" onclick="JavaScript:excluir();removeTool(${tool.id});">Remover</button>
						</td>
					</tr>
				</c:forEach>
		    </table>
		</section>
		
		<section class="container">	
			<form:form action="${s:mvcUrl('TC#listaTools').build() }" method="post">
				<label for="filtrar-filtro">Filtro:</label>
				<input type="text" name="params"  placeholder="Digite o título ou nome da Tag" size="23"/>
				<button type="submit" class="btn btn-primary">Ver</button>
			</form:form>
		</section>
		
	</main>  
</body>

<script src="/js/avaliacao.js"></script>

<%@ include file="/WEB-INF/jsp/template/rodape.jsp" %> 