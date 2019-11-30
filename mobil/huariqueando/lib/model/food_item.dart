import 'package:flutter/foundation.dart';

FooditemList fooditemList = FooditemList(foodItems: [
  FoodItem(
    id: 1,
    nombre: "Huarique 1",
    direccion: "San Miguel",
    telefono: "954133333",
    imgUrl:
        "https://hips.hearstapps.com/pop.h-cdn.co/assets/cm/15/05/480x240/54ca71fb94ad3_-_5summer_skills_burger_470_0808-de.jpg",
  ),
  FoodItem(
    id: 2,
    nombre: "Huarique 2",
    direccion: "Lima",
    telefono: "954133333",
    imgUrl:
        "https://b.zmtcdn.com/data/pictures/chains/8/18427868/1269c190ab2f272599f8f08bc152974b.png",
  ),
  FoodItem(
    id: 3,
    nombre: "Huarique 3",
    direccion: "Callao",
    telefono: "954133333",
    imgUrl: "https://static.food2fork.com/burger53be.jpg",
  ),
  FoodItem(
    id: 4,
    nombre: "Huarique 4",
    direccion: "Breña",
    telefono: "954133333",
    imgUrl: "https://static.food2fork.com/36725137eb.jpg",
  ),
  FoodItem(
    id: 5,
    nombre: "Huarique 5",
    direccion: "Jesus Maria",
    telefono: "954133333",
    imgUrl: "https://static.food2fork.com/turkeyburger300x200ff84052e.jpg",
  ),
  FoodItem(
    id: 6,
    nombre: "Huarique 6",
    direccion: "Miraflores",
    telefono: "954133333",
    imgUrl:
        "https://cdn.pixabay.com/photo/2018/03/04/20/08/burger-3199088__340.jpg",
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
