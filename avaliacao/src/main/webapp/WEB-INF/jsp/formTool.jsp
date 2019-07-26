<%@ include file="/WEB-INF/jsp/template/cabecalho.jsp" %> 
<body>    
    
    <header>
		<div class="container">
			<h1 class="titulo">Cadastro de Ferramenta</h1>
		</div>
	</header>
	<main>
		<section class="container">	
			<span> ${sucesso}</span>
			<ol>
				<c:forEach items="${erros}" var="erro">
					<li class="erro">${erro }</li>
				</c:forEach>
			</ol>
				
			<form:form action="${s:mvcUrl('TC#salvar').build() }" method="post"> 
				<div class="form-group">
					<label>T�tulo</label>
					<input name="title"  value="${tool.title}" placeholder="digite o t�tulo da sua ferramenta" class="form-control" />
					<form:errors path="title" />
				</div>
				<div class="form-group">
			        <label>Link</label>
					<input name="link" value="${tool.link}" placeholder="digite o link da sua ferramenta" class="form-control" />
			        <form:errors path="link" />
				</div>
				<div class="form-group">
					<label>Descri��o</label>
					<input name="description" value="${tool.description}" placeholder="digite a descri��o da sua ferramenta" class="form-control" />
			        <form:errors path="description" />
				</div>
				<div class="form-group">
					<label>Tags</label>
					<select name="tagIds" multiple="multiple" class="form-control">
	                   <c:forEach items="${tags}" var="tag">
	                       <option value="${tag.id}" >
	                           <c:out value="${tag.name}" />
	                       </option>
	                   </c:forEach>
		            <select>			
				</div>
				<button type="submit" class="btn btn-primary">Cadastrar</button>
			</form:form>
		</section>
	</main> 	  
</body>

<%@ include file="/WEB-INF/jsp/template/rodape.jsp" %> 