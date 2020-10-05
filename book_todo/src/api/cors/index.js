import axios from 'axios';

const instance =axios.create({
    withCredentials:true
});

instance.interceptors.request.use(
    config => {
        let accessToken = sessionStorage.getItem('access_token');
        if(accessToken !== null){
            config.headers.Authorzation = accessToken;
        }
       return config; 
    },
    error=>{
        return Promise.reject(error);
    }
);

export default instance;