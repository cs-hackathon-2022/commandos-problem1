// component
import Iconify from '../../components/Iconify';

// ----------------------------------------------------------------------

const getIcon = (name) => <Iconify icon={name} width={22} height={22} />;

const navConfig = [
  {
    title: 'dashboard',
    path: '/dashboard/app',
    icon: getIcon('eva:pie-chart-2-fill'),
  },
  {
    title: 'take-action',
    path: '/dashboard/take-action',
    icon: getIcon('eva:people-fill'),
  },
  {
    title: 'create-team',
    path: '/dashboard/create-team',
    icon: getIcon('eva:shopping-bag-fill'),
  },
  {
    title: 'allocate-space',
    path: '/dashboard/allocate-space',
    icon: getIcon('eva:shopping-bag-fill'),
  },
  {
    title: 'request-space',
    path: '/dashboard/request-space',
    icon: getIcon('eva:shopping-bag-fill'),
  },
  {
    title: 'login',
    path: '/login',
    icon: getIcon('eva:lock-fill'),
  },
  {
    title: 'register',
    path: '/register',
    icon: getIcon('eva:person-add-fill'),
  },
];

export default navConfig;
