
$(function(){
			
	var pode = false;	
	
});

function excluir() {
	var resposta;
	resposta = confirm("Voce deseja excluir ?");
	if (resposta) {
		pode = true;
		return true;
	}else{
		pode = false;
	}
}

$("button.excluir" ).click(function() {
	if(pode){
		$(this).parent().parent().remove();
	}
});

function removeTool(id){
	if(pode){
		removeToolRest(id)
	}
}

function removeToolRest(id){
    console.log("Removendo Tool: " + id)
    
    $.ajax({
        url: 'http://localhost:8080/rest/tools/' + id,
        method: 'DELETE',
        contentType: 'application/json',
        success: function(result) {
        	console.log("Sucesso" + result);        	
        }, 
        error: function(request, msg, error) {
        	console.log("Error remoção de tool" + error);
        }
    });
}


var campoFiltro = document.querySelector("#filtrar-tabela");

campoFiltro.addEventListener("input", function() {
    var tools = document.querySelectorAll(".tool");

    if (this.value.length > 0) {
        for (var i = 0; i < tools.length; i++) {
            var tool = tools[i];
            var tdNome = tool.querySelector(".info-title");
            var nome = tdNome.textContent;
            var expressao = new RegExp(this.value, "i");

            if (expressao.test(nome)) {
            	tool.classList.remove("invisivel");
            } else {
            	tool.classList.add("invisivel");
            }
        }
    } else {
        for (var i = 0; i < tools.length; i++) {
            var tool = tools[i];
            tool.classList.remove("invisivel");
        }
    }
});








