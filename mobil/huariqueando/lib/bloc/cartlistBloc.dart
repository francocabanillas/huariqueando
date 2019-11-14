import 'dart:async';
import 'package:bloc_pattern/bloc_pattern.dart';
import 'package:huariqueando/model/food_item.dart';
import 'package:rxdart/rxdart.dart';

class CartListBloc extends BlocBase {
  

  var _listController = BehaviorSubject<List<FoodItem>>.seeded([]);



//output
  Stream<List<FoodItem>> get listStream => _listController.stream;

//input
  Sink<List<FoodItem>> get listSink => _listController.sink;


  

//dispose will be called automatically by closing its streams
  @override
  void dispose() {
    _listController.close();
    super.dispose();
  }
}
