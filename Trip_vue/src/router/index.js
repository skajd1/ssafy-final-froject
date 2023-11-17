import { createRouter, createWebHistory } from "vue-router";

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: "/",
      name: "Home",
      component: () => import("../views/Home.vue"),
    },
    {
      path: "/main",
      name: "Main",
      component: () => import("../views/Main.vue"),
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
  ],
});

export default router;
