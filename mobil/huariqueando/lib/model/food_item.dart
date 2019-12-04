import 'dart:convert';
import 'package:http/http.dart'  as http;
import 'package:flutter/foundation.dart';

 Future<List> getData() async{
    final response = await http.get("http://10.142.120.20/vteqweb/restAPP/listarCertificados.php");
    return json.decode(response.body);
  }//
  

FooditemList fooditemList = FooditemList(foodItems: [
  FoodItem(
    id: 1,
    nombre: "Huarique 1",
    direccion: "San Miguel",
    telefono: "954133333",
    imgUrl:
        "https://hips.hearstapps.com/pop.h-cdn.co/assets/cm/15/05/480x240/54ca71fb94ad3_-_5summer_skills_burger_470_0808-de.jpg",
  ),
  
]);

class FooditemList {
  List<FoodItem> foodItems;

  FooditemList({@required this.foodItems});
}

class FoodItem {
  int id;
  String nombre;
  String direccion;
  String telefono;
  String imgUrl;
  int quantity;

  FoodItem({
    @required this.id,
    @required this.nombre,
    @required this.direccion,
    @required this.telefono,
    @required this.imgUrl,
    this.quantity = 1,
  });

  void incrementQuantity() {
    this.quantity = this.quantity + 1;
  }

  void decrementQuantity() {
    this.quantity = this.quantity - 1;
  }
}
