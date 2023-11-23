<script setup>
import { RouterLink, useRoute, useRouter } from "vue-router";
import { usePlanStore } from "@/stores/planStore";
import { deletePlanItem } from "@/api/PlanApi";

import VKaKaoMap from "@/components/MyList/MyListMap.vue";
import TimeLine from "@/components/MyList/TimeLine.vue";

const router = useRouter();
const route = useRoute();
const pid = route.params.pid;
const title = route.query.title;
const store = usePlanStore();
const { planItems } = store;

const Delete = () => {
  deletePlanItem(
    pid,
    () => {
      alert("삭제되었습니다.");
      router.push({ name: "MyList" });
    },
    (e) => {
      console.log(e);
      alert("삭제에 실패했습니다.");
    }
  );
};

planItems(pid);
</script>

<template>
  <h1>{{ title }}</h1>

  <RouterLink :to="{ name: 'MyList' }">목록으로</RouterLink>
  <button @click="Delete()">삭제</button>
  <!-- 지도 -->
  <div class="mapbox">
    <VKaKaoMap></VKaKaoMap>
  </div>
  <!-- planitem에서 해당 pid를 갖고 있는 모든 item 정보 -->
  <div class="timelinebox">
    <TimeLine />
  </div>
</template>

<style scoped>
.mapbox {
  width: 100%;
  height: 470px;
}
.timelinebox {
  padding: 10 auto;
  width: 100%;
  border: 1px solid black;
  height: 280px;
}
</style>
