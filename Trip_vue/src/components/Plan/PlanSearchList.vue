<script setup>
import { ref, watch, reactive } from "vue";
import item from "@/components/Plan/PlanSearchListItem.vue";
import { useTripStore } from "@/stores/tripStore";
import { storeToRefs } from "pinia";

const tripStore = useTripStore();

const { lists, searchData, thema } = storeToRefs(tripStore);
const { getTripList } = tripStore;

const trips = ref([]);
const trips_copied = reactive([]);

watch(lists, () => {
  trips.value = lists;
  trips_copied.value = lists;
});

watch(
  searchData,
  () => {
    getTripList();
  },
  { deep: true }
);

watch(
  thema,
  () => {
    console.log(thema.value);
    filterTripList();
  },
  { deep: true }
);
const filterTripList = () => {
  trips.value = [];
  trips_copied.value.forEach((trip) => {
    thema.value.forEach((t) => {
      if (parseInt(trip.contentTypeId) === parseInt(t)) {
        trips.value.push(trip);
      }
    });
  });
  console.log(trips.value);
};
</script>

<template>
  <div class="container">
    <p>여행지 조회 목록</p>
    <!-- 여행지 썸네일과 그 타이틀이 하나의 컴포넌트가 되고, -->
    <!-- 필터에 맞는 컴포넌트가 여러개 조회된다. -->
    <!-- 가로로 스크롤바 -->
    <div id="items">
      <item v-for="trip in trips.value" :t="trip"></item>
    </div>
  </div>
</template>

<style lang="scss" scoped>
.container {
  width: 300px;
  height: 380px;

  /* border: 1px solid var(--main-color); */
  border-radius: 10px;
  box-shadow: 0 0 5px var(--main-color);

  p {
    text-align: center;
    font-size: 20px;
    margin: 10px;
    font-weight: bold;
  }

  #items {
    overflow-y: auto;
    margin: 1 auto;
    padding: 0;
    width: 100%;
    height: 320px;
  }

  ::-webkit-scrollbar {
    width: 10px;
  }
  /* 
  ::-webkit-scrollbar-track {
    background-color: var(--main-color-bg);
    box-shadow: 0 0 5px var(--main-color);
  } */

  ::-webkit-scrollbar-thumb {
    background-color: var(--main-color);
    border-radius: 10px;
  }
}
</style>
