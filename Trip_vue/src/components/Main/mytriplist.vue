<script setup>
import listitem from "@/components/Main/ListItem.vue";
import { getLikeListInfoByUid } from "@/api/TripApi";
import { useUserStore } from "@/stores/userStore";
import { ref } from "vue";
import { storeToRefs } from "pinia";
const userStore = useUserStore();
const { user } = storeToRefs(userStore);
const uid = user.value.uid;
const items = ref([]);
getLikeListInfoByUid(
  uid,
  (res) => {
    console.log(123);
    items.value = res.data;
  },
  (err) => {
    console.log(err);
  }
);
</script>

<template>
  <div class="container">
    <h2>찜한 여행지</h2>
    <div class="itembox">
      <listitem v-for="item in items" :item="item"></listitem>
    </div>
  </div>
</template>

<style scoped>
.container {
  width: 80%;
  background-color: var(--vt-c-bg);
  color: var(--main-color);
  margin: 0 auto;
  margin-bottom: 1rem;
  padding-bottom: 2rem;
  border-radius: 10px;
}
/* 가로 스크롤바 */
.itembox {
  display: flex;
  overflow: auto;
  white-space: nowrap;
}
::-webkit-scrollbar {
  height: 8px;
}

::-webkit-scrollbar-thumb {
  background-color: var(--main-color);
  border-radius: 10px;
}
</style>
