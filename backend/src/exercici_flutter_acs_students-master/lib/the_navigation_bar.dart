import 'package:exercise_flutter_acs/screen_list_groups.dart';
import 'package:exercise_flutter_acs/screen_list_places.dart';
import 'package:exercise_flutter_acs/tree.dart';
import 'package:flutter/material.dart';
import 'data.dart';

/*class TheNavigationBar {
  late BottomNavigationBar bottomNavigationBar;
  int _selected_index = 0;

  final List<Widget> widgetOptions = [
    ScreenListPlaces(root: getTree("building").root),
    ScreenListGroups(userGroups: Data.userGroups),
    //ScrenFavorites()
  ];

  TheNavigationBar(BuildContext context) {
    bottomNavigationBar = BottomNavigationBar(
      showSelectedLabels: true,
        showUnselectedLabels: false,
        items: const <BottomNavigationBarItem> [
          BottomNavigationBarItem(
              icon: Icon(Icons.apartment),
              label: "Places"),
          BottomNavigationBarItem(
              icon: Icon(Icons.group),
              label: "Group"),
          BottomNavigationBarItem(
              icon: Icon(Icons.favorite),
              label: "Favorites"),
          ],
      currentIndex: _selected_index,
      onTap:
    );
  }
}*/