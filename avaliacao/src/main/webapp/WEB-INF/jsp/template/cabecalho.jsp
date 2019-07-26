<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<htlm>
<head>
	<meta http-equiv="Content-Type" content="text/html">
	<title>Avaliação de SpringBoot da Vetta</title>
	<link href="/css/bootstrap.min.css" rel="stylesheet" />
	<link rel="stylesheet" href="/css/bootstrap-theme.min.css" />
	<link rel="stylesheet" href="/css/avaliacao.css" />	
	<script src="/js/jquery.js"></script>
	<style type="text/css">
        body{
            padding-top: 10px;
        }
    </style>
</head>
<nav class="navbar navbar-inverse">
  <div class="container">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <span class="navbar-brand">Avaliação</span>
    </div>
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li><a href="${s:mvcUrl('TC#listar').build() }" rel="nofollow">Lista de Ferramentas</a></li>
        <li><a href="${s:mvcUrl('TC#form').build() }" rel="nofollow">Cadastro de Ferramentas</a></li>
    </ul>
    </div><!-- /.navbar-collapse -->
  </div>
</nav>
	

	