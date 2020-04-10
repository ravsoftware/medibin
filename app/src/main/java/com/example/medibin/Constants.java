/*
 * @category U321 Wear
 * @copyright Copyright (C) 2017 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */

package com.example.medibin;

/**
 * This class is used to contains the application constants
 *
 * @author ContusTeam <developers@contus.in>
 * @version 2.0
 */

public class Constants {

    public static final int GPS_REQUEST = 1001;

    private static final String PACKAGE_NAME = "com.mahindra.bluesense.w501";

    public static final String GEOFENCES_ADDED_KEY = PACKAGE_NAME + ".GEOFENCES_ADDED_KEY";

    private static final long GEOFENCE_EXPIRATION_IN_HOURS = 12;

    /**
     * For this sample, geofences expire after twelve hours.
     */
    static final long GEOFENCE_EXPIRATION_IN_MILLISECONDS =
            GEOFENCE_EXPIRATION_IN_HOURS * 60 * 60 * 1000;
    static final float GEOFENCE_RADIUS_IN_METERS = 1609; // 1 mile, 1.6 km


    /**
     * Close all Activity
     */
    public static final int RESULT_CLOSE_ALL=555;

    /**
     * Constructor to instantiate object
     */
    private Constants() {
        // Private Constructor to hide default public constructor
    }

    /**
     * Home connection control api
     */
    public static final String HOME_CONNECTION_CONTROL  = "/xuv_500_wear_home_connection_control";

    /**
     * Bluetooth connection validation api
     */
    public static final String CONNECTION_VALIDATION  = "/xuv_500_wear_connection_validation";

    /**
     * Home click control api
     */
    public static final String HOME_CLICK_CONTROL  = "/xuv_500_wear_home_click_control";

    /**
     * Home click control response api
     */
    public static final String AUDIO_CONTROL_RESPONSE  = "/xuv_500_wear_audio_control_response";

    /**
     * Audio control payload path
     */
    public static final String AUDIO_CONTROL_PAYLOAD  = "/xuv_500_wear_audio_control_payload";

    /**
     * Home clicked control
     */
    public static final String CLICKED_CONTROL  = "clicked_control";

    /**
     * Emergency call/sms control api
     */
    public static final String EMERGENCY_ACTIONS_CONTROL = "/xuv_500_wear_emergency_call_sms";

    /**
     * Emergency call control
     */
    public static final String EMERGENCY_CALL_ACTION = "emergency_call_action";

    /**
     * Emergency sms control
     */
    public static final String EMERGENCY_SMS_ACTION = "emergency_sms_action";

    /**
     * Action on emergency sms sent
     */
    public static final String ON_EMERGENCY_SMS_SENT = "on_emergency_sms_sent";

    /**
     * Emergency action
     */
    public static final String EMERGENCY_ACTION = "emergency_call_action";

    /**
     * Climate click control api
     */
    public static final String CLIMATE_ACTIONS_CONTROL  = "/xuv_500_wear_climate_actions_control";

    /**
     * Climate clicked control
     */
    public static final String CLIMATE_ACTION  = "climate_action";

    /**
     * Front AC off action from wear
     */
    public static final String AC_FRONT_OFF  = "0";

    /**
     * Front AC on action from wear
     */
    public static final String AC_FRONT_ON  = "1";

    /**
     * Front AC on action from wear
     */
    public static final String AUTO_OFF  = "2";

    /**
     * Front AC on action from wear
     */
    public static final String AUTO_ON  = "3";
    /**
     * Front AC off action from wear
     */
    public static final String AC_DUAL_OFF  = "4";

    /**
     * Front AC on action from wear
     */
    public static final String AC_DUAL_ON  = "5";

    /**
     * Front AC on action from wear
     */
    public static final String AUTO_AC_ENABLED  = "6";

    /**
     * Front AC on action from wear
     */
    public static final String AUTO_AC_DISABLED  = "7";

    /**
     * Climate temp change action to wear
     */
    public static final String CLIMATE_ACTION_TEMP_CHANGE  = "/xuv_500_wear_climate_action_temp_change";

    /**
     * Climate out temp change action to wear
     */
    public static final String CLIMATE_ACTION_OUT_TEMP_CHANGE  = "/xuv_500_wear_climate_action_out_temp_change";

    /**
     * Climate alert action to wear
     */
    public static final String CLIMATE_ACTION_ALERT  = "/xuv_500_wear_climate_action_alert";

    /**
     * Fuel economy data to wear
     */
    public static final String FUEL_ECONOMY_DATA_CHANGE  = "/xuv_500_wear_fuel_economy_data_change";

    /**
     * Distance to empty data to wear
     */
    public static final String FUEL_DISTANCE_TO_EMPTY_CHANGE  = "/xuv_500_wear_fuel_distance_to_empty_data_change";

    /**
     * Location actions from wear
     */
    public static final String LOCATION_ACTIONS = "/xuv_500_wear_location_actions";

    /**
     * Location action from wear
     */
    public static final String LOCATION_ACTION = "location_action";

    /**
     * Locate vehicle action from wear
     */
    public static final String ACTION_LOCATE_VEHICLE = "1";

    /**
     * Share location action from wear
     */
    public static final String ACTION_SHARE_LOCATION = "2";

    /**
     * Find fuel stations action from wear
     */
    public static final String ACTION_FIND_FUEL_STATIONS = "3";

    /**
     * Home launch api
     */
    public static final String LAUNCH_HOME  = "/xuv_500_wear_home_connection_control";

    /**
     * Home launch api
     */
    public static final String CHECK_INFOTAINMENT_CONNECTION  = "check_infotainment_connection";

    /**
     * Infotainment connected value
     */
    public static final String INFOTAINMENT_CONNECTED  = "100";

    /**
     * Infotainment disconnected value
     */
    public static final String INFOTAINMENT_DISCONNECTED  = "400";

    /**
     * Home command identifier
     */
    public static final String HOME_COMMAND_IDENTIFIER  = "11";

    /**
     * Audio control launch constant from home
     */
    public static final String AUDIO_CONTROL  = "1";

    /**
     * Climate control launch constant from home
     */
    public static final String CLIMATE_CONTROL  = "2";

    /**
     * Emergency assist launch constant from home
     */
    public static final String EMERGENCY_ASSIST  = "3";

    /**
     * Location service launch constant from home
     */
    public static final String LOCATION_SERVICE  = "4";

    /**
     * Tiretronics launch constant from home
     */
    public static final String TIRETRONICS  = "5";

    /**
     * Fuel statistics launch constant from home
     */
    public static final String FUEL_STATISTICS  = "6";

    /**
     * Door open launch constant from home
     */
    public static final String DOOR_OPEN  = "7";

    /**
     * The constant for audio play/pause/mute/unmute
     */
    public static final String AUDIO_PLAY_PAUSE_MUTE_UNMUTE = "audio_pause_mute_unmute";

    /**
     * The constant for audio pause next song or station
     *
     *
     */


    //public static  byte[] AUDIO_NEXT=new byte[]{1,1,1,5,0,1,0,3};

    //public static  byte[] AUDIO_PREVIOUS=new byte[]{1,1,1,6,0,1,0,4};

  /*  public static final String AUDIO_NEXT = "audio_next";

    *//**
     * The constant for audio previous next song or station
     *//*
    public static final String AUDIO_PREVIOUS = "audio_previous";
*/
    /**
     * The api path for audio volume control
     */
    public static final String AUDIO_VOLUME_CONTROL = "/xuv_500_wear_audio_volume_control";

    /**
     * Audio click control api
     */
    public static final String AUDIO_ACTIONS_CONTROL = "/xuv_500_wear_audio_actions_control";

    /**
     * Audio selection control api
     */
    public static final String AUDIO_SELECTION_CONTROL = "/xuv_500_wear_audio_selection_control";

    /**
     * Audio band/song control api
     */
    public static final String AUDIO_BAND_SONG_CONTROL = "/xuv_500_wear_audio_band_song_control";


    /**
     * The constant for audio pause next song or station
     */
    public static final String AUDIO_NEXT = "audio_next";

    /**
     * The constant for audio previous next song or station
     */
    public static final String AUDIO_PREVIOUS = "audio_previous";

    /**
     * The constant for audio play action
     */
    public static final String AUDIO_PLAY_ACTION = "audio_play_action";

    /**
     * The constant for audio pause action
     */
    public static final String AUDIO_PAUSE_ACTION = "audio_pause_action";

    /**
     * The constant for audio pause action
     */
    public static final String AUDIO_MUTE_ACTION = "audio_mute_action";

    /**
     * The constant for audio pause action
     */
    public static final String AUDIO_UNMUTE_ACTION = "audio_unmute_action";

    /**
     * The constant for audio feature not available
     */
    public static final String AUDIO_FEATURE_NOT_AVAILABLE = "audio_feature not available";

    /**
     * The audio volume control data
     */
    public static final String AUDIO_VOLUME_CONTROL_DATA = "audio_volume_control_data";

    /**
     * Home click control request data api
     */
    public static final String AUDIO_CONTROL_REQUEST_DATA = "/xuv_500_wear_audio_request_control_data";

    /**
     * The constant for audio band selection
     */
    public static final String AUDIO_BAND_SELECTION = "audio_band_selection";

    /**
     * The constant for BT audio selection
     */
    public static final String AUDIO_BT_SELECTION = "audio_bt_selection";

    /**
     * The constant for audio aux selection
     */
    public static final String AUDIO_AUX_SELECTION = "audio_aux_selection";

    /**
     * The constant for iPod player selection
     */
    public static final String AUDIO_IPOD_SELECTION = "audio_ipod_selection";

    /**
     * The constant for USB2 selection
     */
    public static final String AUDIO_USB2_SELECTION = "audio_usb2_selection";

    /**
     * The constant for SD-CARD selection
     */
    public static final String AUDIO_SD_SELECTION = "audio_sd_selection";

    /**
     * The constant for IPOD2 selection
     */
    public static final String AUDIO_IPOD2_SELECTION = "audio_ipod2_selection";

    /**
     * The constant for USB selection
     */
    public static final String AUDIO_USB_SELECTION = "audio_usb_selection";

    /**
     * Audio control data
     */
    public static final String AUDIO_CONTROL_DATA  = "audio_control_data";

    /**
     * Door open warning api
     */
    public static final String DOOR_OPEN_WARNING = "/xuv_500_wear_door_open_warning";

    /**
     * Door open warning api
     */
    public static final String DOOR_OPEN_WARNING_NOTIFICATION = "/xuv_500_wear_door_open_warning_notification";

    /**
     * Front left door open
     */
    public static final String FRONT_LEFT_DOOR_OPEN = "front_left_door_open";

    /**
     * Front right door open
     */
    public static final String FRONT_RIGHT_DOOR_OPEN = "front_right_door_open";

    /**
     * Back left door open
     */
    public static final String BACK_LEFT_DOOR_OPEN = "back_left_door_open";

    /**
     * Back right door open
     */
    public static final String BACK_RIGHT_DOOR_OPEN = "back_right_door_open";

    /**
     * Back right door open
     */
    public static final String ALL_DOOR_OPEN = "all_door_open";

    /**
     * Banet door open
     */
    public static final String BANET_DOOR_OPEN = "banet_door_open";

    /**
     * Back door open
     */
    public static final String BACK_DOOR_OPEN = "back_door_open";

    /**
     * Tire pressure warning api
     */
    public static final String TIRE_PRESSURE_WARNING = "/xuv_500_wear_tire_pressure_warning";

    /**
     * Tire pressure warning api
     */
    public static final String TIRE_PRESSURE_WARNING_NOTIFICATION = "/xuv_500_wear_tire_pressure_warning_notification";

    /**
     * Tire temperature warning api
     */
    public static final String TIRE_TEMPERATURE_WARNING_NOTIFICATION = "/xuv_500_wear_tire_temperature_warning_notification";

    /**
     * Front left tire pressure
     */
    public static final String FRONT_LEFT_TIRE_PRESSURE = "front_left_tire_pressure";

    /**
     * Front right tire pressure
     */
    public static final String FRONT_RIGHT_TIRE_PRESSURE = "front_right_tire_pressure";

    /**
     * Back left tire pressure
     */
    public static final String BACK_LEFT_TIRE_PRESSURE = "back_left_tire_pressure";

    /**
     * Back right tire pressure
     */
    public static final String BACK_RIGHT_TIRE_PRESSURE = "back_right_tire_pressure";

    /**
     * Spare tire pressure
     */
    public static final String SPARE_TIRE_PRESSURE = "spare_tire_pressure";

    /**
     * Spare tire pressure
     */
    public static final String SPARE_TIRE_PRESSURE_GREEN = "spare_tire_pressure_green";

    //pick file constant

    public static final int PICK_FILE=101;

    /**
     * Finish the activity
     */
    public static final String FINISH_ACTIVITY = "finish_activity";

    /**
     * The preference constant for FUEL LIMIT 30 KM REACHED
     */
    public static final String FUEL_LIMIT_30_KM = "fuel_limit_30_km_reached";

    /**
     * The preference constant for FUEL LIMIT 20 KM REACHED
     */
    public static final String FUEL_LIMIT_20_KM = "fuel_limit_20_km_reached";

    /**
     * The preference constant for FUEL LIMIT 10 KM REACHED
     */
    public static final String FUEL_LIMIT_10_KM = "fuel_limit_10_km_reached";

    public static final String VEHICLE_U321 = "06";
    public static final String VEHICLE_U321_MID = "04";
    public static final String VEHICLE_U321_HIGH = "05";
    public static final String VEHICLE_U321_HIGH_PLUS = "06";


    /**
     * The constant to store foreground activity
     */
    public static final String FOREGROUND_ACTIVITY = "foreground_activity";

    /**
     * The constant for door open activity
     */
    public static final String DOOR_OPEN_ACTIVITY = "door_open_activity";

    /**
     * The constant for climate control activity
     */
    public static final String CLIMATE_CONTROL_ACTIVITY = "climate_control_activity";

    /**
     * The constant for location service activity
     */
    public static final String LOCATION_SERVICE_ACTIVITY = "location_service_activity";


    /**
     * The constant for audio control activity
     */
    public static final String AUDIO_CONTROL_ACTIVITY = "audio_control_activity";

    /**
     * The constant for emergency assist activity
     */
    public static final String EMERGENCY_ASSIST_ACTIVITY = "emergency_assist_activity";

    /**
     * Door open change
     */
    public static final String DOOR_OPEN_CHANGE = "door_open _change";

    /**
     * Home click control api
     */
    public static final String HOME_PAGE_CONTROL  = "/xuv_321_wear_home_page_control";

    /**
     * Green drive status
     */
    public static final String GREEN_DRIVE_STATUS  = "/xuv300_green_drive_status";


    /**
     * Back left tire pressure
     */
    public static final String BACK_LEFT_TIRE_PRESSURE_GREEN = "back_left_tire_pressure_green";
    /**
     * Back right tire pressure
     */
    public static final String BACK_RIGHT_TIRE_PRESSURE_GREEN = "back_right_tire_pressure_green";
    /**
     * Front left tire pressure
     */
    public static final String FRONT_LEFT_TIRE_PRESSURE_GREEN = "front_left_tire_pressure_green";
    /**
     * Front right tire pressure
     */
    public static final String FRONT_RIGHT_TIRE_PRESSURE_GREEN = "front_right_tire_pressure_green";
    /**
     * Show tire pressure
     */
    public static final String SHOW_TIRE_PRESSURE = "show_tire_pressure";
    /**
     * AccesoryMode Wear
     */
    public static final String ACCESS_MODE_CONTROL  = "/u321_access_mode_validation";
    /**
     * Audio Available Resource
     */
    public static final String AUDIO_AVAIL_RESOURCE = "/xuv_500_audio_avail";
    /**
     * Audio Available Resource
     */
    public static final String AUDIO_IPOD_RESOURCE = "/xuv_500_ipod_avail";
    /**
     * Audio Available Resource
     */
    public static final String AUDIO_USB_RESOURCE = "/xuv_500_usb_avail";
    /**
     * Audio Available Resource
     */
    public static final String AUDIO_BT_RESOURCE = "/xuv_500_bt_avail";
    /**
     * Audio Available Resource
     */
    public static final String AUDIO_USB2_RESOURCE = "/xuv_500_usb2_avail";
    /**
     * Audio Available Resource
     */
    public static final String AUDIO_IPOD2_RESOURCE = "/xuv_500_ipod2_avail";
/**
     * Audio Available Resource
     */
    public static final String AUDIO_BAND_RESOURCE = "/xuv_500_band_avail";
/**
     * Audio Available Resource
     */
    public static final String AUDIO_SD_RESOURCE = "/xuv_500_sd_avail";
/**
     * Audio Available Resource
     */
    public static final String AUDIO_AUX_RESOURCE = "/xuv_500_aux_avail";

/**
     * Audio Available Resource
     */
    public static final String AUDIO_UNAVAIL_RESOURCE = "/xuv_500_audio_unavail";
    /**
     * The constant for fuel statistics activity
     */
    public static final String FUEL_STATISTICS_ACTIVITY = "fuel_statistics_activity";
    /**
     * The constant for tire pressure activity
     */
    public static final String TIRE_PRESSURE_ACTIVITY = "tire_pressure_activity";
    /**
     * The constant for recreating Audio activity
     */
    public static final String RECREATE_AUDIO_ACTIVITY = "recreate_audio_activity";
    /**
     * The constant for recreating Audio activity
     */
    public static final String RECREATE_CLIMATE_ACTIVITY = "recreate_climate_activity";
    /**
     * The constant for recreating Audio activity
     */
    public static final String RECREATE_FUEL_ACTIVITY = "recreate_fuel_activity";
    /**
     * The constant for recreating Audio activity
     */
    public static final String RECREATE_DOOR_ACTIVITY = "recreate_door_activity";
    /**
     * The constant for recreating Audio activity
     */
    public static final String RECREATE_LOCATION_ACTIVITY = "recreate_location_activity";
    /**
     * The constant for recreating ECall activity
     */
    public static final String RECREATE_ECALL_ACTIVITY = "recreate_ecall_activity";
}
