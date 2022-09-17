import { Navigate, useRoutes } from 'react-router-dom';
// layouts
import DashboardLayout from './layouts/dashboard';
import LogoOnlyLayout from './layouts/LogoOnlyLayout';
//
import Blog from './pages/Blog';
import TakeAction from './pages/TakeAction';
import Login from './pages/Login';
import NotFound from './pages/Page404';
import Register from './pages/Register';
import CreateTeam from './pages/CreateTeam';
import DashboardApp from './pages/DashboardApp';
import AllocateSpace from "./pages/AllocateSpace";
import RequestSpace from "./pages/RequestSpace";

// ----------------------------------------------------------------------

export default function Router() {
  return useRoutes([
    {
      path: '/dashboard',
      element: <DashboardLayout />,
      children: [
        { path: 'app', element: <DashboardApp /> },
        { path: 'take-action', element: <TakeAction /> },
        { path: 'create-team', element: <CreateTeam /> },
        { path: 'allocate-space', element: <AllocateSpace /> },
        { path: 'request-space', element: <RequestSpace /> },
        { path: 'login', element: <Login />},
        { path: 'register', element: <Register />},
      ],
    },

    {
      path: '/',
      element: <LogoOnlyLayout />,
      children: [
        { path: '/', element: <Navigate to="/dashboard/app" /> },
        { path: '/login', element: <Navigate to="/dashboard/login" /> },
        { path: '/register', element: <Navigate to="/dashboard/register" /> },
        { path: '404', element: <NotFound /> },
        { path: '*', element: <Navigate to="/404" /> },
      ],
    },
    {
      path: '*',
      element: <Navigate to="/404" replace />,
    },
  ]);
}
