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
  <div class="mylistdetail">
    <div id="top">
      <div>
        <h1 id="title">{{ title }}</h1>
      </div>

      <div id="btn">
        <button><RouterLink :to="{ name: 'MyList' }" class="offhover">목록으로</RouterLink></button>

        <button @click="Delete()">삭제</button>
      </div>
    </div>

    <!-- 지도 -->
    <div class="mapbox">
      <VKaKaoMap></VKaKaoMap>
    </div>
    <!-- planitem에서 해당 pid를 갖고 있는 모든 item 정보 -->
    <div class="timelinebox">
      <TimeLine />
    </div>
  </div>
</template>

<style lang="scss" scoped>
.mylistdetail {
  #top {
    display: flex;
    justify-content: space-between;

    #title {
      color: var(--main-color);
      font-size: 50px;
      font-weight: bold;
      margin-bottom: 20px;
    }

    #btn {
      display: flex;
      flex-direction: row;
      align-items: end;
      padding-bottom: 10px;
      font-size: 20px;

      button {
        margin-left: 10px;
        background-color: transparent;
        border: none;
        color: var(--main-color);

        .offhover {
          &:hover {
            color: var(--main-color);
            text-decoration: none;
          }
        }

        &:hover {
          font-weight: bold;
        }
      }
    }
  }
  .mapbox {
    width: 100%;
    height: 400px;
  }

  .timelinebox {
    margin-bottom: 20px;
  }
}
</style>
