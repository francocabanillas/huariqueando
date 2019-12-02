$(function(){

    var $distritos = $('#distritos');
    var $platos = $('#platos');
    
    var $idusuario = $('#idusuario');
    var $nombre = $('#nombre');
    var $apellido = $('#apellido');
    var $dni = $('#dni');
    var $correo = $('#correo');
    var $direccion = $('#direccion');
    var $telefono = $('#telefono');

    $distritos.append('<option>seleccione</option>');
    $.ajax({
     type: 'GET',
     dataType: "json",
     url:'http://localhost:8080/api/distritos',
     success: function(data){
       $.each(data, function(i, distrito){
           $distritos.append('<option>'+ distrito.nombre +  '</option>');
       });
       
     }
     ,error: function(xhr, status, error) {
        var err = eval("(" + xhr.responseText + ")");
        alert(err.Message);
      }
    }
    );

    $.ajax({
        type: 'GET',
        dataType: "json",
        url:'http://localhost:8080/api/restaurante/platos/1',
        success: function(data){
          $.each(data, function(i, plato){
              
              $platos.append('<tr>    '+
                                '        <th>'+plato.id+'</th>'+
                                '        <th>'+plato.nombre+'</th>'+
                                '        <th>'+plato.etiqueta+'</th>'+
                                '        <th>'+plato.precio+'</th>'+
                                '</tr>');
          });
          
        }
        ,error: function(xhr, status, error) {
           var err = eval("(" + xhr.responseText + ")");
           alert(err.Message);
         }
       }
    );

    $.ajax({
      type: 'GET',
      dataType: "json",
      url:'http://localhost:8080/api/restaurante/1',
      success: function(data){
        document.getElementById("idusuario").value=data.id;
        document.getElementById("nombre").value=data.usuario;
        document.getElementById("apellido").value=data.nombre;
        document.getElementById("dni").value=data.identificacion;
        document.getElementById("correo").value=data.correo;
        document.getElementById("direccion").value=data.direccion;
        document.getElementById("telefono").value=data.telefono;
            
      }
      ,error: function(xhr, status, error) {
         var err = eval("(" + xhr.responseText + ")");
         alert(err.Message);
       }
     }
  );





});