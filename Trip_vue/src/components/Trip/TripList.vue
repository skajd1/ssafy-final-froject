<script setup>
import item from "./TripListItem.vue";
import { ref, onMounted } from "vue";
import { useRoute, useRouter } from "vue-router";
import { getTripInfoByTitle } from "@/api/TripApi.js";
// import { getTripInfo } from "@/api/TripApi";

import { getLikeListInfoByUid } from "@/api/TripApi";
import { useUserStore } from "@/stores/userStore";
import { storeToRefs } from "pinia";

const userStore = useUserStore();
const { user } = storeToRefs(userStore);
const uid = user.value.uid;
const list = ref([]);

const emit = defineEmits(["changeList"]);

const router = useRouter();
const route = useRoute();
const keyword = route.query.keyword;
const trips = ref([]);

onMounted(() => {
  getTripInfoByTitle(
    keyword,
    (res) => {
      if (res.data.length === 0) {
        alert("검색 결과가 없습니다.");
        router.push("/");

        return;
      }
      trips.value = res.data;
    },
    (e) => {
      console.log(e);
    }
  );

  getLikeListInfoByUid(
    uid,
    (res) => {
      list.value = res.data;
      console.log(list.value);
    },
    (err) => {
      console.log(err);
    }
  );
});

const changeList = () => {
  getLikeListInfoByUid(
    uid,
    (res) => {
      list.value = res.data;

      console.log(list.value);
    },
    (err) => {
      console.log(err);
    }
  );
};
</script>
<template>
  <div class="container">
    <div class="title">
      <h2>여행지 조회 목록</h2>
    </div>

    <!-- 여행지 썸네일과 그 타이틀이 하나의 컴포넌트가 되고, -->
    <!-- 가로로 스크롤바 -->

    <div id="items">
      <item
        v-for="trip in trips"
        :key="trip.tid"
        :t="trip"
        :list="list"
        @changeList="changeList"
      ></item>
    </div>
  </div>
</template>

<style lang="scss" scoped>
.container {
  display: flex;
  flex-direction: column;
  margin: 1 auto;
  padding: 0;
  width: 80%;

  .title {
    color: var(--main-color);
    font-weight: bold;
    text-align: center;
    margin-bottom: 10px;
  }

  #items {
    display: flex;
    flex-wrap: nowrap;
    overflow-x: auto;
    overflow-y: hidden;
    margin: 1 auto;

    padding-top: 10px;
    width: 100%;
    height: 100%;
    padding-bottom: 20px;
  }
}

::-webkit-scrollbar {
  height: 10px;
}

::-webkit-scrollbar-track {
  background-color: var(--main-color-bg);
  border-radius: 10px;
}

::-webkit-scrollbar-thumb {
  background-color: var(--main-color);
  border-radius: 10px;
}
</style>
