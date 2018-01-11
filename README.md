# Server for rooms management

### Description
This server host a H2 database and provides a REST API for client applications. The API is available at the following url: https://pure-island-76277.herokuapp.com/api/.

### API
*Retrieve information*
* __/api/buildings__: gives the list of the buildings
* __/api/buildings/[buildingId]__: gives the detail of the building number buildingId
* __/api/rooms__: gives the list of the rooms
* __/api/rooms/[roomId]__: gives the detail of the room number roomId
* __/api/rooms/list-with-light-on__: gives the list of the rooms with light on
* __/api/rooms/list-with-light-off__: gives the list of the rooms with light off
* __/api/rooms/list-with-ringer-on__: gives the list of the rooms with ringer on
* __/api/rooms/list-with-ringer-off__: gives the list of the rooms with ringer off
* __/api/lights__: gives the status of all the lights
* __/api/noises__: gives the status of all the ringers

*Send requests*
* __/api/rooms/[roomId]/switch-light__: switch the light of the room number roomId
* __/api/rooms/[roomId]/switch-ringer__: switch the ringer of the room number roomId
* __/api/rooms/switch-all-lights-on__: switch all the lights on
* __/api/rooms/switch-all-lights-off__: switch all the lights off
* __/api/rooms/switch-all-ringers-on__: switch all the ringers on
* __/api/rooms/switch-all-ringers-off__: switch all the ringers off
