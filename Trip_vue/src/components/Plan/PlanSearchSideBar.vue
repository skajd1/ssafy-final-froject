<script setup>
import PlanSearchDetail from "@/components/Plan/PlanSearchDetail.vue";
import PlanSearchList from "@/components/Plan/PlanSearchList.vue";
import PlanSearchBar from "@/components/Plan/PlanSearchBar.vue";
import { ref, onMounted } from "vue";
import { useUserStore } from "@/stores/userStore";
import { useTripStore } from "@/stores/tripStore";
import { storeToRefs } from "pinia";

const userStore = useUserStore();
const tripStore = useTripStore();
const { user } = storeToRefs(userStore);
const uid = user.value.uid;

const { getLikeListInfo } = tripStore;

onMounted(() => {
  getLikeListInfo(uid);
});

const is_expanded = ref(false);

const ToggleMenu = () => {
  is_expanded.value = !is_expanded.value;
};
</script>

<template>
  <aside :class="`${is_expanded && 'is-expanded'}`">
    <div class="logo">
      <img src="@/assets/foot.png" alt="search" />
    </div>

    <div class="menu-toggle-wrap">
      <button class="menu-toggle" @click="ToggleMenu">
        <span class="material-icons"> keyboard_double_arrow_right </span>
      </button>
    </div>

    <div class="menu">
      <PlanSearchBar />
      <PlanSearchDetail />
      <PlanSearchList />
    </div>
  </aside>
</template>

<style lang="scss" scoped>
aside {
  display: flex;
  flex-direction: column;
  width: calc(2rem + 32px);

  height: 750px;
  overflow: hidden;

  padding: 1rem;
  position: fixed;
  z-index: 5;

  background-color: var(--main-color-bg);
  color: white;

  transition: 0.2s ease-out;

  .logo {
    margin-bottom: 1rem;

    img {
      width: 3rem;
    }
  }

  .menu-toggle-wrap {
    display: flex;
    justify-content: flex-end;
    margin-bottom: 1rem;

    position: relative;
    top: 0;
    transition: 0.2s ease-out;

    .menu-toggle {
      transition: 0.2s ease-out;

      .material-icons {
        font-size: 2rem;
        color: white;
        transition: 0.2s ease-out;
      }

      &:hover {
        .material-icons {
          color: var(--main-color);
          transform: translateX(0.5rem);
        }
      }
    }
  }

  .menu {
    opacity: 0;
    width: 330px;
    margin: 0 auto;
  }

  &.is-expanded {
    width: 350px;

    .menu-toggle-wrap {
      top: -3rem;
      .menu-toggle {
        transform: rotate(-180deg);
      }
    }

    .menu {
      opacity: 1;
    }
  }
}

button {
  cursor: pointer;
  appearance: none;
  border: none;
  outline: none;
  background: none;
}
</style>
