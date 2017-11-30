$(document).ready(function() {
	$('.eventoId').dblclick(function() {
		$.ajax({
			url : "findEvento",
			type : 'post',
			data : "id=" + $(this).find('span').html(),
			async : false,
			success : function(evento) {
				$('#id').val(evento.id);
				$('#descricao').val(evento.descricao);
				$('#email').val(evento.email);
			},
			error : function(result) {
				alert("Erro requisição");
			}
		})
	});
	
	$('.linkLista').each(function() {
		$(this).attr("href", $(this).attr("href") + $(this).parent().parent().find('.eventoId').find('span').html());
	});
	
});