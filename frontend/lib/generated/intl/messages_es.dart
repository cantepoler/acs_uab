// DO NOT EDIT. This is code generated via package:intl/generate_localized.dart
// This is a library that provides messages for a es locale. All the
// messages from the main program should be duplicated here with the same
// function name.

// Ignore issues from commonly used lints in this file.
// ignore_for_file:unnecessary_brace_in_string_interps, unnecessary_new
// ignore_for_file:prefer_single_quotes,comment_references, directives_ordering
// ignore_for_file:annotate_overrides,prefer_generic_function_type_aliases
// ignore_for_file:unused_import, file_names, avoid_escaping_inner_quotes
// ignore_for_file:unnecessary_string_interpolations, unnecessary_string_escapes

import 'package:intl/intl.dart';
import 'package:intl/message_lookup_by_library.dart';

final messages = new MessageLookup();

typedef String MessageIfAbsent(String messageStr, List<dynamic> args);

class MessageLookup extends MessageLookupByLibrary {
  String get localeName => 'es';

  static String m0(id) => "Puerta ${id}";

  static String m1(action) =>
      "Acción \'${action}\' no posible, compruebe si hay puertas abiertas";

  static String m2(name) => "Info ${name}";

  static String m3(name) => "Horario ${name}";

  static String m4(name) => "Usuario ${name}";

  final messages = _notInlinedMessages(_notInlinedMessages);
  static Map<String, Function> _notInlinedMessages(_) => <String, Function>{
    "accept": MessageLookupByLibrary.simpleMessage("Aceptar"),
    "actionClose": MessageLookupByLibrary.simpleMessage("Cerrar"),
    "actionLock": MessageLookupByLibrary.simpleMessage("Bloquear"),
    "actionOpen": MessageLookupByLibrary.simpleMessage("Abrir"),
    "actionUnlock": MessageLookupByLibrary.simpleMessage("Desbloquear"),
    "actionUnlockShortly": MessageLookupByLibrary.simpleMessage(
      "Desbloquear brevemente",
    ),
    "actions": MessageLookupByLibrary.simpleMessage("Acciones"),
    "actionsSaved": MessageLookupByLibrary.simpleMessage(
      "¡Acciones guardadas correctamente!",
    ),
    "appTitle": MessageLookupByLibrary.simpleMessage("ACS"),
    "areaLockedCorrectly": MessageLookupByLibrary.simpleMessage(
      "Área bloqueada correctamente",
    ),
    "areaUnlockedCorrectly": MessageLookupByLibrary.simpleMessage(
      "Área desbloqueada correctamente",
    ),
    "credential": MessageLookupByLibrary.simpleMessage("Credencial"),
    "dateError": MessageLookupByLibrary.simpleMessage(
      "La fecha de inicio debe ser anterior a la fecha de fin.",
    ),
    "description": MessageLookupByLibrary.simpleMessage("Descripción"),
    "doorClosed": MessageLookupByLibrary.simpleMessage(
      "La puerta ha sido cerrada",
    ),
    "doorLocked": MessageLookupByLibrary.simpleMessage(
      "La puerta ha sido bloqueada",
    ),
    "doorOpened": MessageLookupByLibrary.simpleMessage(
      "La puerta ha sido abierta",
    ),
    "doorTitle": m0,
    "doorUnlocked": MessageLookupByLibrary.simpleMessage(
      "La puerta ha sido desbloqueada",
    ),
    "doorUnlockedShortly": MessageLookupByLibrary.simpleMessage(
      "La puerta se desbloqueó brevemente",
    ),
    "enterText": MessageLookupByLibrary.simpleMessage("Introduzca texto"),
    "errorPropCheck": m1,
    "favorites": MessageLookupByLibrary.simpleMessage("Favoritos"),
    "from": MessageLookupByLibrary.simpleMessage("Desde"),
    "groups": MessageLookupByLibrary.simpleMessage("Grupos"),
    "incorrectData": MessageLookupByLibrary.simpleMessage("Datos incorrectos"),
    "info": MessageLookupByLibrary.simpleMessage("Info"),
    "infoTitle": m2,
    "name": MessageLookupByLibrary.simpleMessage("Nombre"),
    "nameGroup": MessageLookupByLibrary.simpleMessage("Nombre del grupo"),
    "noFavorites": MessageLookupByLibrary.simpleMessage("Sin favoritos"),
    "noProppedDoors": MessageLookupByLibrary.simpleMessage(
      "Sin puertas forzadas",
    ),
    "places": MessageLookupByLibrary.simpleMessage("Lugares"),
    "propped": MessageLookupByLibrary.simpleMessage("Forzadas"),
    "recent": MessageLookupByLibrary.simpleMessage("Recientes"),
    "saved": MessageLookupByLibrary.simpleMessage("¡Guardado!"),
    "schedule": MessageLookupByLibrary.simpleMessage("Horario"),
    "scheduleTitle": m3,
    "submit": MessageLookupByLibrary.simpleMessage("Confirmar"),
    "timeError": MessageLookupByLibrary.simpleMessage(
      "La hora de inicio debe ser anterior a la hora de fin.",
    ),
    "to": MessageLookupByLibrary.simpleMessage("Hasta"),
    "user": MessageLookupByLibrary.simpleMessage("Usuario"),
    "userGroups": MessageLookupByLibrary.simpleMessage("Grupos de usuarios"),
    "users": MessageLookupByLibrary.simpleMessage("Usuarios"),
    "usersTitle": m4,
    "weekdays": MessageLookupByLibrary.simpleMessage("Días de la semana"),
  };
}
