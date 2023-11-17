import { createRouter, createWebHistory } from "vue-router";
import Home from "../views/Home.vue";
import Main from "../views/Main.vue";

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: "/",
      name: "Home",
      component: Home,
    },
    {
      path: "/main",
      name: "Main",
      component: Main,
    },
    {
      path: "/tripselect",
      name: "TripSelect",
      component: () => import("../views/Trip/TripSelectView.vue"),
    },
    {
      path: "/trip/:sido/:gugun/:theme",
      name: "TripList",
      component: () => import("../views/Trip/TripListView.vue"),
    },
    {
      path: "/trip/:tid",
      name: "TripDetail",
      component: () => import("../views/Trip/TripDetailView.vue"),
    },
    {
      path: "/mylist",
      name: "MyList",
      component: () => import("../views/MyList/MyListView.vue"),
    },
    {
      path: "/mylist/:pid",
      name: "MyListDetail",
      component: () => import("../views/MyList/MyListDetailView.vue"),
    },
    {
      path: "/myplan/:pid",
      name: "PlanDetail",
      component: () => import("../views/Plan/PlanDetailView.vue"),
    },
    {
      path: "/plan/insert",
      name: "PlanInsert",
      component: () => import("../views/Plan/PlanInsertView.vue"),
    },
    {
      path: "/board",
      name: "BoardList",
      component: () => import("../views/Board/BoardList.vue"),
    },
    {
      path: "/board/:bid",
      name: "BoardDetail",
      component: () => import("../views/Board/BoardDetail.vue"),
    },
    {
      path: "/board/insert",
      name: "BoardInsert",
      component: () => import("../views/Board/BoardInsert.vue"),
    },
    {
      path: "/user/login",
      name: "Login",
      component: () => import("../views/User/Login.vue"),
    },
  ],
});

router.beforeEach((to, from) => {
  // if (response.status == 404) {
  //   return { name: "Home" };
  // }
});

export default router;
