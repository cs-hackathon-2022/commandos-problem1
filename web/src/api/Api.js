import axios from "axios";
import {employeeConfig} from "../layouts/dashboard/EmployeeConfig";
export const BASE_SERVER_URL = 'http://localhost:8080/api';
 export default class Api {

     static  axiosPostApi(requestURL, paramObject, resolve, reject ){
         return axios.post(requestURL, paramObject).then(function (response) {
                 resolve(response);
         }).catch(function (error) {
                 reject(error);
         });
    }

     static axiosGetApi(requestURL, resolve, reject) {
         return axios.get(requestURL).then((response)=>{
             resolve(response.data);
         }).catch((error)=>{
             reject(error);
         });
     }

 }
