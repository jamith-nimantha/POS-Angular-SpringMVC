export class SETTINGS {
  public static HTTP_PREFIX = '/api';

  public static ENDPOINTS = {
    getAllCustomer : {
      url: SETTINGS.HTTP_PREFIX + '/customer/get-all',
      type: 'GET'
    },
    addCustomer : {
      url: SETTINGS.HTTP_PREFIX + '/customer/save',
      type: 'POST'
    },
    updateCustomer : {
      url: SETTINGS.HTTP_PREFIX + '/customer/update',
      type: 'POST'
    },
    deleteCustomer:{
      url: SETTINGS.HTTP_PREFIX + '/customer/delete'
    }
  }
}
