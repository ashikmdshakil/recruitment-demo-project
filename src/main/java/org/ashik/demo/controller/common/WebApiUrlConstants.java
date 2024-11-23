package com.cnsbd.carwash.controller.common;

public class WebApiUrlConstants {
    public final static String API_URI_PREFIX = "/api/v1";
    public final static String PATH_VAR_ID = "/{id}";

    //public API for Application status check
    public final static String APPLICATION_STATUS_API = "/app-status";
    public final static String APPLICATION_ALL_STATUS_API = APPLICATION_STATUS_API + "/all";

    public final static String AUTH_API = API_URI_PREFIX + "/auth";
    public final static String AUTH_LOGIN_API = AUTH_API + "/login";
    public final static String AUTH_PASSWORD_GENERATE_API = AUTH_LOGIN_API + "/generate-password";

    public final static String ROLE_API = API_URI_PREFIX + "/role";
    public final static String USER_TYPE_ROLE_API = API_URI_PREFIX + "/user-type-role-mapping";


    //Person Info
    public final static String CLIENT_INFO_API = API_URI_PREFIX + "/client-info";
    public final static String CLIENT_INFO_SAVE_API = CLIENT_INFO_API + "/create";
    public final static String CLIENT_INFO_BY_ID_API = CLIENT_INFO_API + PATH_VAR_ID;
    public final static String CLIENT_INFO_LIST_API = CLIENT_INFO_API + "/get-client-info";
    public final static String CLIENT_SHORT_INFO_LIST_API = CLIENT_INFO_API + "/get-client-short-info";

    // user profile
    public final static String USER_PROFILE_API = API_URI_PREFIX + "/user";
    public final static String USER_PROFILE_WEB_API = API_URI_PREFIX + "/web/user";

    public final static String USER_PROFILE_BY_ID_API = USER_PROFILE_API + PATH_VAR_ID;
    public final static String USER_CHANGE_PASSWORD_API = USER_PROFILE_API + "/change-password";
    public final static String USER_MENU_PERMISSION = USER_PROFILE_API + "/get-user-menu-permission";

    public final static String USER_MOBILE_NUMBER_VERIFY_API = USER_PROFILE_API + "/mobile-number/verify";
    public final static String USER_MOBILE_NUMBER_VERIFY_OTP_API = USER_PROFILE_API + "/mobile-number/verify-otp";

    public final static String MAIN_MENU_API = API_URI_PREFIX + "/main-menu";
    public final static String MAIN_MENU_PERMISSION = MAIN_MENU_API + "/permission" + PATH_VAR_ID;
    public final static String MAIN_MENU_PERMISSION_CREATE = MAIN_MENU_API + "/create-permission";
    public final static String MAIN_MENU_PERMISSION_UPDATE = MAIN_MENU_API + "/update-permission";
    public final static String ACCESS_MENU = API_URI_PREFIX + "/access/menus/";

    //DASHBOARD
    public final static String DASHBOARD = API_URI_PREFIX + "/dashboard";
    public final static String TOTAL = DASHBOARD + "/total";
    public final static String TOTAL_LINE_CHART = DASHBOARD + "/total-line-chart";
    public final static String TOTAL_PIE_CHART = DASHBOARD + "/total-pie-chart";

    // lookup
    public final static String COMMON_API = API_URI_PREFIX + "/common";
    public final static String COMMON_USER_TYPE_API = COMMON_API + "/user-type";
    public final static String COMMON_VEHICLE_TYPE_API = COMMON_API + "/vehicle-type";
    public final static String COMMON_SERVICE_TYPE_API = COMMON_API + "/service-type";
    public final static String COMMON_LINKED_ACCOUNT_TYPE_API = COMMON_API + "/linked-account-type";
    public final static String COMMON_DIVISION_API = COMMON_API + "/division";
    public final static String COMMON_WORKFLOW_TYPE_API = COMMON_API + "/workflow-type";
    public final static String COMMON_DISTRICT_API = COMMON_API + "/district/{division_id}";
    public final static String COMMON_THANA_API = COMMON_API + "/thana/{district_id}";
    public final static String COMMON_MISCELLANEOUS_REPORT_TYPE_API = COMMON_API + "/miscellaneous-report-type";
    public final static String COMMON_SPECIFIC_EXPRESS_REPORT_API = COMMON_API + "/specific-express-report";

    public final static String COMMON_COUNTRY_API = COMMON_API + "/country";
    public final static String COMMON_PROVINCE_API = COMMON_API + "/province/{countryId}";
    public final static String COMMON_CITY_API = COMMON_API + "/city/{provinceId}";
    public final static String COMMON_TAX_FEE_TYPE_API = COMMON_API + "/tax-fee-type";


    public final static String LANE_SCREEN_API = API_URI_PREFIX + "/screen/que";

    public final static String SHIFT_SETUP_API = API_URI_PREFIX + "/shift-setup";


    // shift management
    public final static String SHIFT_MANAGEMENT_API = API_URI_PREFIX + "/shift-management";
    public final static String SHIFT_MANAGEMENT_VIEW_API = SHIFT_MANAGEMENT_API + "/view";
    public final static String SHIFT_MANAGEMENT_CLONE_API = SHIFT_MANAGEMENT_API + "/clone";
    public final static String SHIFT_MANAGEMENT_UPDATE_API = SHIFT_MANAGEMENT_API + "/update";
    public final static String SHIFT_MANAGEMENT_STATUS_UPDATE_API = SHIFT_MANAGEMENT_API + "/status-update";
    public final static String SHIFT_USER_ATTENDANCE_API = "/shift-user-attendance";


    // sub test type
    public final static String SUB_TEST_TYPE_API = API_URI_PREFIX + "/subtest";
    public final static String SUB_TEST_TYPE_PATH_VAR_API = SUB_TEST_TYPE_API + PATH_VAR_ID;


    // report
    public final static String REPORT_DEMO = API_URI_PREFIX + "/report/demo";
    public final static String REPORT_INVENTORY_DETAILS = API_URI_PREFIX + "/report/get-inventory-datatable";

    //report PDF generate
    public final static String REPORT_PUBLISHED_RESULT_PDF = API_URI_PREFIX + "/report/get-result-publish-pdf";
    public final static String REPORT_INSPECTION_CANCEL_PDF = API_URI_PREFIX + "/report/get-inspection-cancel-pdf";

    //Print
    public final static String PRINT_API = API_URI_PREFIX + "/print";
    public final static String BSP_APPOINTMENT_PRINT_API = PRINT_API + "/bsp-appointment-print";


    //Log
    public final static String API_ACCESS_LOG = API_URI_PREFIX + "/api-access-log";
    public final static String ACTIVITY_LOG_API = API_URI_PREFIX + "/activity-log";
    public final static String ERROR_LOG_API = API_URI_PREFIX + "/error-log";

    // workflow
    public final static String WORKFLOW_SETUP_API = API_URI_PREFIX + "/workflow-setup";
    public final static String WORKFLOW_SETUP_PATH_VAR_API = WORKFLOW_SETUP_API + PATH_VAR_ID;

    public final static String WORKFLOW_API = API_URI_PREFIX + "/workflow";
    public final static String WORKFLOW_API_NOTIFICATIONS = WORKFLOW_API + "/notifications";
    public final static String WORKFLOW_API_DASHBOARD = WORKFLOW_API + "/dashboard";
    public final static String WORKFLOW_APPROVAL_API = WORKFLOW_API + "/approval";

    // setting & setup
    public final static String SCHEDULE_TASK_SETUP = API_URI_PREFIX + "/schedule-task-setup";
    public final static String SETTINGS_SETUP = API_URI_PREFIX + "/settings-setup";

    // app version
    public final static String WEB_APP_VERSION = API_URI_PREFIX + "/app-version";


    //  vehicle-info
    public final static String VEHICLE_INFO_API = API_URI_PREFIX + "/vehicle-info";
    public final static String VEHICLE_INFO_BY_ID_API = VEHICLE_INFO_API + PATH_VAR_ID;

    public final static String VEHICLE_SHORT_INFO = API_URI_PREFIX + "/get-vehicle-short-info" + "/{clientId}";
    public final static String VEHICLE_COLOR_INFO = API_URI_PREFIX + "/get-vehicle-color-info";

    //    vehicle-garage
    public final static String GARAGE_INFO_API = API_URI_PREFIX + "/garage-info";
    public final static String GARAGE_LIST_BY_CLIENT_ID_API = GARAGE_INFO_API + "/{clientId}";

    //  vehicle-owner-info
    public final static String CLIENT_VEHICLE_LIST_API = API_URI_PREFIX + "/client-vehicle/{clientId}";
    public final static String GARAGE_VEHICLE_LIST_API = API_URI_PREFIX + "/garage-vehicle/{garageId}";


    // Subscription
    public final static String SUBSCRIPTION_API = API_URI_PREFIX + "/subscription";
    public final static String SUBSCRIPTION_BY_ID_API = SUBSCRIPTION_API + PATH_VAR_ID;
    public final static String SUBSCRIPTION_BY_USER_API = SUBSCRIPTION_API + "/user";
    public final static String SUBSCRIPTION_BY_USER_ACTIVE_API = SUBSCRIPTION_API + "/user/active";


    //  Vehicle-center
    public final static String VEHICLE_CENTER_API = API_URI_PREFIX + "/vehicle-center";
    public final static String VEHICLE_CENTER_BY_CENTER_ID_API = VEHICLE_CENTER_API + "/{centerId}";

    public final static String VEHICLE_CENTER_TAX_FEE_API = API_URI_PREFIX + "/vehicle-center/tax-fee";
    public final static String VEHICLE_CENTER_TAX_FEE_UPDATE_API = VEHICLE_CENTER_TAX_FEE_API + "/update";

    //  Tax-Fee-Rule
    public final static String TAX_FEE_RULE_API = API_URI_PREFIX + "/tax-fee";
    public final static String TAX_FEE_RULE_BY_ID_API = TAX_FEE_RULE_API + PATH_VAR_ID;
    public final static String TAX_FEE_RULE_INFO_API = API_URI_PREFIX + "/tax-fee-info";


    public final static String VEHICLE_SERVICE_API = API_URI_PREFIX + "/vehicle-service";
    public final static String VEHICLE_SERVICE_RATE_API = VEHICLE_SERVICE_API + "/rate";
    public final static String VEHICLE_SERVICE_RATE_BY_ID_API = VEHICLE_SERVICE_RATE_API + "/{serviceId}";

    public final static String VEHICLE_SERVICE_ADD_ONS_API = VEHICLE_SERVICE_API + "/add-ons/vehicle-service";
    public final static String VEHICLE_SERVICE_ADD_ONS_GET_API = VEHICLE_SERVICE_ADD_ONS_API + "/{addOnId}";
    public final static String VEHICLE_PACKAGE_AND_SERVICE_LIST_API = VEHICLE_SERVICE_API + "/get-package-and-services";
    public final static String VEHICLE_SERVICES_LIST_API = VEHICLE_SERVICE_API + "/get-services";
    public final static String VEHICLE_SERVICES_ALL_LIST_API = VEHICLE_SERVICE_API + "/get-all-services";


    //    SLOT
    public final static String SLOT_INFO_API = API_URI_PREFIX + "/slot-info";
    public final static String SLOT_INFO_BY_CENTER_ID_API = SLOT_INFO_API + "/center/{centerId}";


    //    VEHICLE BOOKING SERVICE
    public final static String VEHICLE_SERVICE_BOOKING_API = API_URI_PREFIX + "/veh-service-booking";
    public final static String VEHICLE_SERVICE_BOOKING_SUMMARY_API = VEHICLE_SERVICE_BOOKING_API + "/summary";
    public final static String VEHICLE_SERVICE_BOOKING_LIST_BY_CLIENT_ID_API = VEHICLE_SERVICE_BOOKING_API + "/client/{clientId}";
    public final static String VEHICLE_SERVICE_BOOKING_LIST_BY_USER_ID_API = VEHICLE_SERVICE_BOOKING_API + "/user/{userId}";
    public final static String VEHICLE_SERVICE_BOOKING_CANCEL_API = VEHICLE_SERVICE_BOOKING_API + "/cancel";
    public final static String VEHICLE_SERVICE_BOOKING_PAYMENT_API = VEHICLE_SERVICE_BOOKING_API + "/payment";
    public final static String VEHICLE_SERVICE_BOOKING_LIST_API = API_URI_PREFIX + "/calendar-service-booking";
    public final static String VEHICLE_SERVICE_BOOKING_SLOT_API = API_URI_PREFIX + "/get-available-slots/{date}";
    public final static String CENTER_WISE_VEHICLE_SERVICE_BOOKING_LIST_API = VEHICLE_SERVICE_BOOKING_API + "/center";

    // OFFER
    public final static String OFFER_LIST_API = API_URI_PREFIX + "/offer";
    public final static String OFFER_API = API_URI_PREFIX + "/offer";
    public final static String OFFER_BY_ID_API = OFFER_API + "/{offerId}";
    public final static String OFFER_AVAILABLE = OFFER_LIST_API + "/available_offer";

    // VEHICLE INSPECTION STAGE
    public final static String VEHICLE_INSPECTION_STAGE_API = API_URI_PREFIX + "/inspection-stage";
    public final static String VEHICLE_INSPECTION_IMAGE_API = API_URI_PREFIX + "/inspection-image";

    // VEHICLE INSPECTION
    public final static String VEHICLE_INSPECTION_API = API_URI_PREFIX + "/inspection";
}
