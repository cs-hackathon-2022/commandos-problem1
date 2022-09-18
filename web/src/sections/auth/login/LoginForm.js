import * as Yup from 'yup';
import { useState } from 'react';
import { useNavigate } from 'react-router-dom';
// form
import { useForm } from 'react-hook-form';
import { yupResolver } from '@hookform/resolvers/yup';
// @mui
import { Link, Stack, IconButton, InputAdornment } from '@mui/material';
import { LoadingButton } from '@mui/lab';
// components
import Iconify from '../../../components/Iconify';
import { FormProvider, RHFTextField, RHFCheckbox } from '../../../components/hook-form';
import {Axios} from "axios";
import Api from "../../../api/Api";

// ----------------------------------------------------------------------

export default function LoginForm() {
  const navigate = useNavigate();
    const defaultValues = {
        email: '',
        password: '',
    };
  const [formValues,setFormValues] = useState({...defaultValues})

  const [showPassword, setShowPassword] = useState(false);

  const LoginSchema = Yup.object().shape({
    // email: Yup.string().email('Email must be a valid email address').required('Email is required'),
    // password: Yup.string().required('Password is required'),
  });



  const methods = useForm({
    resolver: yupResolver(LoginSchema),
    defaultValues,
  });

  const {
    handleSubmit,
    formState: { isSubmitting },
  } = methods;

  const onSubmit = async () => {
      sessionStorage.setItem('isUserLoggedIn', 'Y');
      new Promise( (resolve,reject)=>{
           Api.axiosPostApi('/login',{
              email:formValues.email,
              password:formValues.password
          },resolve, reject);
      }).then((res)=> {
          console.log('login repsonse===',res)
          // sessionStorage.setItem('employeeData',loginResponse)
          navigate('/dashboard/app', { replace: true });

      }).catch(()=>{

      })

  };

  return (
    <FormProvider methods={methods} onSubmit={handleSubmit(onSubmit)}>
      <Stack spacing={3}>
        <RHFTextField name="email" label="Email address" value={formValues.email} onChange={(e)=>{
            console.log('email=====',e.target.value)
            setFormValues({...formValues,email:e.target.value});
        }} />

        <RHFTextField
          name="password"
          label="Password"
          value={formValues.password}
          onChange={(e)=>{
              setFormValues({...formValues,password:e.target.value});
          }}
          type={showPassword ? 'text' : 'password'}
          InputProps={{
            endAdornment: (
              <InputAdornment position="end">
                <IconButton onClick={() => setShowPassword(!showPassword)} edge="end">
                  <Iconify icon={showPassword ? 'eva:eye-fill' : 'eva:eye-off-fill'} />
                </IconButton>
              </InputAdornment>
            ),
          }}
        />
      </Stack>

      <Stack direction="row" alignItems="center" justifyContent="space-between" sx={{ my: 2 }}>
        <RHFCheckbox name="remember" label="Remember me" />
        <Link variant="subtitle2" underline="hover">
          Forgot password?
        </Link>
      </Stack>

      <LoadingButton fullWidth size="large" type="submit" variant="contained" loading={isSubmitting}>
        Login
      </LoadingButton>
    </FormProvider>
  );
}
