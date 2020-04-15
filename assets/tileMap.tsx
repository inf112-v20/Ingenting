<?xml version="1.0" encoding="UTF-8"?>
<tileset version="1.2" tiledversion="1.3.2" name="TestTile" tilewidth="64" tileheight="64" tilecount="136" columns="8">
 <image source="tiles.png" width="512" height="1088"/>
 <tile id="0" type="pusher">
  <properties>
   <property name="direction" value="south"/>
   <property name="even" type="bool" value="true"/>
   <property name="type" value="pusher"/>
  </properties>
 </tile>
 <tile id="1" type="pusher">
  <properties>
   <property name="direction" value="west"/>
   <property name="even" type="bool" value="true"/>
   <property name="type" value="pusher"/>
  </properties>
 </tile>
 <tile id="2" type="pusher">
  <properties>
   <property name="direction" value="north"/>
   <property name="even" type="bool" value="false"/>
   <property name="type" value="pusher"/>
  </properties>
 </tile>
 <tile id="3" type="pusher">
  <properties>
   <property name="direction" value="east"/>
   <property name="even" type="bool" value="true"/>
   <property name="type" value="pusher"/>
  </properties>
 </tile>
 <tile id="4" type="floor">
  <properties>
   <property name="type" value="floor"/>
  </properties>
 </tile>
 <tile id="5" type="hole">
  <properties>
   <property name="type" value="hole"/>
  </properties>
 </tile>
 <tile id="6" type="repair">
  <properties>
   <property name="doubleRepair" type="bool" value="true"/>
   <property name="type" value="repair"/>
  </properties>
 </tile>
 <tile id="7" type="wall">
  <properties>
   <property name="direction" value="northwest"/>
   <property name="lasers" type="int" value="0"/>
   <property name="type" value="wall"/>
  </properties>
 </tile>
 <tile id="8" type="pusher">
  <properties>
   <property name="direction" value="south"/>
   <property name="even" type="bool" value="false"/>
   <property name="type" value="pusher"/>
  </properties>
 </tile>
 <tile id="9" type="pusher">
  <properties>
   <property name="direction" value="west"/>
   <property name="even" type="bool" value="false"/>
   <property name="type" value="pusher"/>
  </properties>
 </tile>
 <tile id="10" type="pusher">
  <properties>
   <property name="direction" value="north"/>
   <property name="even" type="bool" value="true"/>
   <property name="type" value="pusher"/>
  </properties>
 </tile>
 <tile id="11" type="pusher">
  <properties>
   <property name="direction" value="east"/>
   <property name="even" type="bool" value="false"/>
   <property name="type" value="pusher"/>
  </properties>
 </tile>
 <tile id="12" type="conveyor">
  <properties>
   <property name="direction" value="north"/>
   <property name="speed" type="int" value="2"/>
   <property name="type" value="conveyor"/>
  </properties>
 </tile>
 <tile id="13" type="conveyor">
  <properties>
   <property name="direction" value="east"/>
   <property name="speed" type="int" value="2"/>
   <property name="type" value="conveyor"/>
  </properties>
 </tile>
 <tile id="14" type="repair">
  <properties>
   <property name="doubleRepair" type="bool" value="false"/>
   <property name="type" value="repair"/>
  </properties>
 </tile>
 <tile id="15" type="wall">
  <properties>
   <property name="direction" value="southwest"/>
   <property name="lasers" type="int" value="0"/>
   <property name="type" value="wall"/>
  </properties>
 </tile>
 <tile id="16" type="conveyor">
  <properties>
   <property name="direction" value="south"/>
   <property name="speed" type="int" value="2"/>
   <property name="type" value="conveyor"/>
  </properties>
 </tile>
 <tile id="17" type="conveyor">
  <properties>
   <property name="direction" value="west"/>
   <property name="speed" type="int" value="2"/>
   <property name="type" value="conveyor"/>
  </properties>
 </tile>
 <tile id="18" type="conveyor">
  <properties>
   <property name="direction" value="east"/>
   <property name="speed" type="int" value="2"/>
   <property name="type" value="conveyor"/>
  </properties>
 </tile>
 <tile id="19" type="conveyor">
  <properties>
   <property name="direction" value="south"/>
   <property name="speed" type="int" value="2"/>
   <property name="type" value="conveyor"/>
  </properties>
 </tile>
 <tile id="20" type="conveyor">
  <properties>
   <property name="direction" value="south"/>
   <property name="speed" type="int" value="2"/>
   <property name="type" value="conveyor"/>
  </properties>
 </tile>
 <tile id="21" type="conveyor">
  <properties>
   <property name="direction" value="west"/>
   <property name="speed" type="int" value="2"/>
   <property name="type" value="conveyor"/>
  </properties>
 </tile>
 <tile id="22" type="wall">
  <properties>
   <property name="direction" value="west"/>
   <property name="lasers" type="int" value="0"/>
   <property name="type" value="wall"/>
  </properties>
 </tile>
 <tile id="23" type="wall">
  <properties>
   <property name="direction" value="southeast"/>
   <property name="lasers" type="int" value="0"/>
   <property name="type" value="wall"/>
  </properties>
 </tile>
 <tile id="24" type="conveyor">
  <properties>
   <property name="direction" value="east"/>
   <property name="speed" type="int" value="2"/>
   <property name="type" value="conveyor"/>
  </properties>
 </tile>
 <tile id="25" type="conveyor">
  <properties>
   <property name="direction" value="north"/>
   <property name="speed" type="int" value="2"/>
   <property name="type" value="conveyor"/>
  </properties>
 </tile>
 <tile id="26" type="conveyor">
  <properties>
   <property name="direction" value="north"/>
   <property name="speed" type="int" value="2"/>
   <property name="type" value="conveyor"/>
  </properties>
 </tile>
 <tile id="27" type="conveyor">
  <properties>
   <property name="direction" value="west"/>
   <property name="speed" type="int" value="2"/>
   <property name="type" value="conveyor"/>
  </properties>
 </tile>
 <tile id="28" type="wall">
  <properties>
   <property name="direction" value="north"/>
   <property name="lasers" type="int" value="0"/>
   <property name="type" value="wall"/>
  </properties>
 </tile>
 <tile id="29" type="wall">
  <properties>
   <property name="direction" value="east"/>
   <property name="lasers" type="int" value="0"/>
   <property name="type" value="wall"/>
  </properties>
 </tile>
 <tile id="30" type="wall">
  <properties>
   <property name="direction" value="south"/>
   <property name="lasers" type="int" value="0"/>
   <property name="type" value="wall"/>
  </properties>
 </tile>
 <tile id="31" type="wall">
  <properties>
   <property name="direction" value="northeast"/>
   <property name="lasers" type="int" value="0"/>
   <property name="type" value="wall"/>
  </properties>
 </tile>
 <tile id="32" type="conveyor">
  <properties>
   <property name="direction" value="south"/>
   <property name="speed" type="int" value="1"/>
   <property name="type" value="conveyor"/>
  </properties>
 </tile>
 <tile id="33" type="conveyor">
  <properties>
   <property name="direction" value="west"/>
   <property name="speed" type="int" value="1"/>
   <property name="type" value="conveyor"/>
  </properties>
 </tile>
 <tile id="34" type="conveyor">
  <properties>
   <property name="direction" value="east"/>
   <property name="speed" type="int" value="1"/>
   <property name="type" value="conveyor"/>
  </properties>
 </tile>
 <tile id="35" type="conveyor">
  <properties>
   <property name="direction" value="south"/>
   <property name="speed" type="int" value="1"/>
   <property name="type" value="conveyor"/>
  </properties>
 </tile>
 <tile id="36" type="wall">
  <properties>
   <property name="direction" value="north"/>
   <property name="lasers" type="int" value="1"/>
   <property name="type" value="wall"/>
  </properties>
 </tile>
 <tile id="37" type="wall">
  <properties>
   <property name="direction" value="east"/>
   <property name="lasers" type="int" value="1"/>
   <property name="type" value="wall"/>
  </properties>
 </tile>
 <tile id="38" type="laser">
  <properties>
   <property name="count" type="int" value="1"/>
   <property name="cross" type="bool" value="false"/>
   <property name="type" value="laser"/>
  </properties>
 </tile>
 <tile id="39" type="laser">
  <properties>
   <property name="count" type="int" value="1"/>
   <property name="cross" type="bool" value="true"/>
   <property name="type" value="laser"/>
  </properties>
 </tile>
 <tile id="40" type="conveyor">
  <properties>
   <property name="direction" value="east"/>
   <property name="speed" type="int" value="1"/>
   <property name="type" value="conveyor"/>
  </properties>
 </tile>
 <tile id="41" type="conveyor">
  <properties>
   <property name="direction" value="north"/>
   <property name="speed" type="int" value="1"/>
   <property name="type" value="conveyor"/>
  </properties>
 </tile>
 <tile id="42" type="conveyor">
  <properties>
   <property name="direction" value="north"/>
   <property name="speed" type="int" value="1"/>
   <property name="type" value="conveyor"/>
  </properties>
 </tile>
 <tile id="43" type="conveyor">
  <properties>
   <property name="direction" value="west"/>
   <property name="speed" type="int" value="1"/>
   <property name="type" value="conveyor"/>
  </properties>
 </tile>
 <tile id="44" type="wall">
  <properties>
   <property name="direction" value="south"/>
   <property name="lasers" type="int" value="1"/>
   <property name="type" value="wall"/>
  </properties>
 </tile>
 <tile id="45" type="wall">
  <properties>
   <property name="direction" value="west"/>
   <property name="lasers" type="int" value="1"/>
   <property name="type" value="wall"/>
  </properties>
 </tile>
 <tile id="46" type="laser">
  <properties>
   <property name="count" type="int" value="1"/>
   <property name="cross" type="bool" value="false"/>
   <property name="type" value="laser"/>
  </properties>
 </tile>
 <tile id="48" type="conveyor">
  <properties>
   <property name="direction" value="north"/>
   <property name="speed" type="int" value="1"/>
   <property name="type" value="conveyor"/>
  </properties>
 </tile>
 <tile id="49" type="conveyor">
  <properties>
   <property name="direction" value="south"/>
   <property name="speed" type="int" value="1"/>
   <property name="type" value="conveyor"/>
  </properties>
 </tile>
 <tile id="50" type="conveyor">
  <properties>
   <property name="direction" value="west"/>
   <property name="speed" type="int" value="1"/>
   <property name="type" value="conveyor"/>
  </properties>
 </tile>
 <tile id="51" type="conveyor">
  <properties>
   <property name="direction" value="east"/>
   <property name="speed" type="int" value="1"/>
   <property name="type" value="conveyor"/>
  </properties>
 </tile>
 <tile id="52" type="rotator">
  <properties>
   <property name="rotateRight" type="bool" value="false"/>
   <property name="type" value="rotator"/>
  </properties>
 </tile>
 <tile id="53" type="rotator">
  <properties>
   <property name="rotateRight" type="bool" value="true"/>
   <property name="type" value="rotator"/>
  </properties>
 </tile>
 <tile id="54" type="flag">
  <properties>
   <property name="type" value="flag"/>
   <property name="value" type="int" value="1"/>
  </properties>
 </tile>
 <tile id="56" type="conveyor">
  <properties>
   <property name="direction" value="north"/>
   <property name="speed" type="int" value="1"/>
   <property name="type" value="conveyor"/>
  </properties>
 </tile>
 <tile id="57" type="conveyor">
  <properties>
   <property name="direction" value="east"/>
   <property name="speed" type="int" value="1"/>
   <property name="type" value="conveyor"/>
  </properties>
 </tile>
 <tile id="58" type="conveyor">
  <properties>
   <property name="direction" value="south"/>
   <property name="speed" type="int" value="1"/>
   <property name="type" value="conveyor"/>
  </properties>
 </tile>
 <tile id="59" type="conveyor">
  <properties>
   <property name="direction" value="west"/>
   <property name="speed" type="int" value="1"/>
   <property name="type" value="conveyor"/>
  </properties>
 </tile>
 <tile id="60" type="conveyor">
  <properties>
   <property name="direction" value="east"/>
   <property name="speed" type="int" value="1"/>
   <property name="type" value="conveyor"/>
  </properties>
 </tile>
 <tile id="61" type="conveyor">
  <properties>
   <property name="direction" value="south"/>
   <property name="speed" type="int" value="1"/>
   <property name="type" value="conveyor"/>
  </properties>
 </tile>
 <tile id="62" type="flag">
  <properties>
   <property name="type" value="flag"/>
   <property name="value" type="int" value="2"/>
  </properties>
 </tile>
 <tile id="64" type="conveyor">
  <properties>
   <property name="direction" value="north"/>
   <property name="speed" type="int" value="1"/>
   <property name="type" value="conveyor"/>
  </properties>
 </tile>
 <tile id="65" type="conveyor">
  <properties>
   <property name="direction" value="east"/>
   <property name="speed" type="int" value="1"/>
   <property name="type" value="conveyor"/>
  </properties>
 </tile>
 <tile id="66" type="conveyor">
  <properties>
   <property name="direction" value="south"/>
   <property name="speed" type="int" value="1"/>
   <property name="type" value="conveyor"/>
  </properties>
 </tile>
 <tile id="67" type="conveyor">
  <properties>
   <property name="direction" value="west"/>
   <property name="speed" type="int" value="1"/>
   <property name="type" value="conveyor"/>
  </properties>
 </tile>
 <tile id="68" type="conveyor">
  <properties>
   <property name="direction" value="north"/>
   <property name="speed" type="int" value="1"/>
   <property name="type" value="conveyor"/>
  </properties>
 </tile>
 <tile id="69" type="conveyor">
  <properties>
   <property name="direction" value="west"/>
   <property name="speed" type="int" value="1"/>
   <property name="type" value="conveyor"/>
  </properties>
 </tile>
 <tile id="70" type="flag">
  <properties>
   <property name="type" value="flag"/>
   <property name="value" type="int" value="3"/>
  </properties>
 </tile>
 <tile id="72" type="conveyor">
  <properties>
   <property name="direction" value="north"/>
   <property name="speed" type="int" value="2"/>
   <property name="type" value="conveyor"/>
  </properties>
 </tile>
 <tile id="73" type="conveyor">
  <properties>
   <property name="direction" value="east"/>
   <property name="speed" type="int" value="2"/>
   <property name="type" value="conveyor"/>
  </properties>
 </tile>
 <tile id="74" type="conveyor">
  <properties>
   <property name="direction" value="south"/>
   <property name="speed" type="int" value="2"/>
   <property name="type" value="conveyor"/>
  </properties>
 </tile>
 <tile id="75" type="conveyor">
  <properties>
   <property name="direction" value="west"/>
   <property name="speed" type="int" value="2"/>
   <property name="type" value="conveyor"/>
  </properties>
 </tile>
 <tile id="76" type="conveyor">
  <properties>
   <property name="direction" value="north"/>
   <property name="speed" type="int" value="2"/>
   <property name="type" value="conveyor"/>
  </properties>
 </tile>
 <tile id="77" type="conveyor">
  <properties>
   <property name="direction" value="east"/>
   <property name="speed" type="int" value="2"/>
   <property name="type" value="conveyor"/>
  </properties>
 </tile>
 <tile id="78" type="flag">
  <properties>
   <property name="type" value="flag"/>
   <property name="value" type="int" value="4"/>
  </properties>
 </tile>
 <tile id="80" type="conveyor">
  <properties>
   <property name="direction" value="east"/>
   <property name="speed" type="int" value="2"/>
   <property name="type" value="conveyor"/>
  </properties>
 </tile>
 <tile id="81" type="conveyor">
  <properties>
   <property name="direction" value="south"/>
   <property name="speed" type="int" value="2"/>
   <property name="type" value="conveyor"/>
  </properties>
 </tile>
 <tile id="82" type="conveyor">
  <properties>
   <property name="direction" value="west"/>
   <property name="speed" type="int" value="2"/>
   <property name="type" value="conveyor"/>
  </properties>
 </tile>
 <tile id="83" type="conveyor">
  <properties>
   <property name="direction" value="north"/>
   <property name="speed" type="int" value="2"/>
   <property name="type" value="conveyor"/>
  </properties>
 </tile>
 <tile id="84" type="conveyor">
  <properties>
   <property name="direction" value="west"/>
   <property name="speed" type="int" value="2"/>
   <property name="type" value="conveyor"/>
  </properties>
 </tile>
 <tile id="85" type="conveyor">
  <properties>
   <property name="direction" value="south"/>
   <property name="speed" type="int" value="2"/>
   <property name="type" value="conveyor"/>
  </properties>
 </tile>
 <tile id="86" type="wall">
  <properties>
   <property name="direction" value="north"/>
   <property name="lasers" type="int" value="2"/>
   <property name="type" value="wall"/>
  </properties>
 </tile>
 <tile id="90" type="hole">
  <properties>
   <property name="type" value="hole"/>
  </properties>
 </tile>
 <tile id="91" type="hole">
  <properties>
   <property name="type" value="hole"/>
  </properties>
 </tile>
 <tile id="92" type="wall">
  <properties>
   <property name="direction" value="east"/>
   <property name="lasers" type="int" value="2"/>
   <property name="type" value="wall"/>
  </properties>
 </tile>
 <tile id="93" type="wall">
  <properties>
   <property name="direction" value="south"/>
   <property name="lasers" type="int" value="2"/>
   <property name="type" value="wall"/>
  </properties>
 </tile>
 <tile id="94" type="wall">
  <properties>
   <property name="direction" value="west"/>
   <property name="lasers" type="int" value="2"/>
   <property name="type" value="wall"/>
  </properties>
 </tile>
 <tile id="100" type="laser">
  <properties>
   <property name="count" type="int" value="2"/>
   <property name="cross" type="bool" value="true"/>
   <property name="type" value="laser"/>
  </properties>
 </tile>
 <tile id="101" type="laser">
  <properties>
   <property name="count" type="int" value="2"/>
   <property name="cross" type="bool" value="false"/>
   <property name="type" value="laser"/>
  </properties>
 </tile>
 <tile id="102" type="laser">
  <properties>
   <property name="count" type="int" value="2"/>
   <property name="cross" type="bool" value="false"/>
   <property name="type" value="laser"/>
  </properties>
 </tile>
 <tile id="104" type="hole">
  <properties>
   <property name="type" value="hole"/>
  </properties>
 </tile>
 <tile id="105" type="hole">
  <properties>
   <property name="type" value="hole"/>
  </properties>
 </tile>
 <tile id="106" type="hole">
  <properties>
   <property name="type" value="hole"/>
  </properties>
 </tile>
 <tile id="107" type="hole">
  <properties>
   <property name="type" value="hole"/>
  </properties>
 </tile>
 <tile id="108" type="hole">
  <properties>
   <property name="type" value="hole"/>
  </properties>
 </tile>
 <tile id="109" type="hole">
  <properties>
   <property name="type" value="hole"/>
  </properties>
 </tile>
 <tile id="112" type="hole">
  <properties>
   <property name="type" value="hole"/>
  </properties>
 </tile>
 <tile id="113" type="hole">
  <properties>
   <property name="type" value="hole"/>
  </properties>
 </tile>
 <tile id="114" type="hole">
  <properties>
   <property name="type" value="hole"/>
  </properties>
 </tile>
 <tile id="115" type="hole">
  <properties>
   <property name="type" value="hole"/>
  </properties>
 </tile>
 <tile id="116" type="hole">
  <properties>
   <property name="type" value="hole"/>
  </properties>
 </tile>
 <tile id="117" type="hole">
  <properties>
   <property name="type" value="hole"/>
  </properties>
 </tile>
 <tile id="120" type="player_start_1">
  <properties>
   <property name="type" value="player_start_1"/>
  </properties>
 </tile>
 <tile id="121" type="player_start_2">
  <properties>
   <property name="type" value="player_start_2"/>
  </properties>
 </tile>
 <tile id="122" type="player_start_3">
  <properties>
   <property name="type" value="player_start_3"/>
  </properties>
 </tile>
 <tile id="123" type="player_start_4">
  <properties>
   <property name="type" value="player_start_4"/>
  </properties>
 </tile>
 <tile id="128" type="player_start_5">
  <properties>
   <property name="type" value="player_start_5"/>
  </properties>
 </tile>
</tileset>
