$(document).ready(function () {
    $("tr #btnDelete").click(function () {
        var idp = $(this).parent().find("#idp").val();
        swal({
            title: "estas seguro?",
            text: "Una vez eliminado,no podrás recuperarlo!",
            icon: "warning",
            buttons: true,
            dangerMode: true,
        })
                .then((willDelete) => {
                    if (willDelete) {
                        eliminar(idp);
                        swal("Se ha borrado el producto de la reserva", {
                            icon: "success",
                        }).then((willDelete)=>{
                            if(willDelete){
                            parent.location.href="ControladorReserva?accion=carrito";
                            }
                            
                        });
                    } else {
                        swal("Producto no eliminado");
                    }
                }); 
        
    });

    function eliminar(idp) {
        var url = "ControladorReserva?accion=Delete";
        $.ajax({
            type: 'POST',
            url: url,
            data: "idp=" + idp,
            success: function (data, textStatus, jqXHR) {
                
            }
        })
    }
    
   
    $("tr #cantidad").click(function(){
        var idp=$(this).parent().find("#idpd").val();
        var cantidad=$(this).parent().find("#cantidad").val();
        var url="ControladorReserva?accion=ActualizarCantidad";
        $.ajax({
            type: 'POST',
            url: url,
            data:"idp=" + idp + "&Cantidad=" + cantidad,
            success: function (data, textStatus, jqXHR) {
              location.href="ControladorReserva?accion=carrito";
            }
        });
        
        
    });
});